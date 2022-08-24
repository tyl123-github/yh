package com.yh.admin.service.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yh.admin.service.dto.UserDTO;
import com.yh.admin.service.entity.YhRole;
import com.yh.admin.service.entity.YhUser;
import com.yh.admin.service.entity.YhUserRole;
import com.yh.admin.service.mapper.YhUserRoleMapper;
import com.yh.admin.service.service.YhRoleService;
import com.yh.admin.service.service.YhUserService;
import com.yh.admin.service.vo.RoleVo;
import com.yh.admin.service.vo.UserVo;
import com.yh.common.core.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author yl_tao
 * @date 2022/5/13 23:18
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class YhUserController {

    private final YhUserService yhUserService;

    private final YhUserRoleMapper yhUserRoleMapper;

    private final YhRoleService yhRoleService;

    @PostMapping("/list")
    public ApiResult<List<UserVo>> list(@RequestBody(required = false) UserDTO userDto) {
        LambdaQueryWrapper<YhUser> lambdaQueryWrapper = Wrappers.<YhUser>lambdaQuery();
        lambdaQueryWrapper.eq(YhUser::getDeleteFlag, 0);
        if (userDto != null) {
            if (StrUtil.isNotBlank(userDto.getKw())) {
                lambdaQueryWrapper.nested(i -> {
                    i.like(YhUser::getUserName, userDto.getKw()).or()
                            .like(YhUser::getName, userDto.getKw());
                });
            }
        }
        List<YhUser> list = yhUserService.list(lambdaQueryWrapper);
        List<UserVo> userVoList = list.stream().map(e -> {
            e.setName(DesensitizedUtil.chineseName(e.getName()));
            e.setMobile(DesensitizedUtil.mobilePhone(e.getMobile()));
            UserVo userVo = BeanUtil.toBean(e, UserVo.class);
            List<YhUserRole> yhUserRoles = yhUserRoleMapper.selectList(Wrappers.<YhUserRole>lambdaQuery().eq(YhUserRole::getUserId, e.getUserId()));
            List<Long> roleIds = yhUserRoles.stream().map(YhUserRole::getRoleId).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(roleIds)) {
                List<YhRole> yhRoles = yhRoleService.listByIds(roleIds);
                List<RoleVo> collect = yhRoles.stream().map(yhRole ->
                        BeanUtil.toBean(yhRole, RoleVo.class)
                ).collect(Collectors.toList());
                userVo.setRoleVos(collect);
            }
            return userVo;
        }).collect(Collectors.toList());
        return ApiResult.success(userVoList);
    }

    @PostMapping("/save")
    public ApiResult<Long> save(@RequestBody UserDTO userDto) {
        YhUser yhUser = BeanUtil.toBean(userDto, YhUser.class);
        yhUserService.save(yhUser);
        userDto.getRoleIds().stream().map(roleId -> {
            YhUserRole yhUserRole = new YhUserRole();
            yhUserRole.setUserId(yhUser.getUserId());
            yhUserRole.setRoleId(roleId);
            return yhUserRole;
        }).forEach(yhUserRoleMapper::insert);
        return ApiResult.success(yhUser.getUserId());
    }

    @PostMapping("/updateById")
    public ApiResult<Long> updateById(@RequestBody UserDTO userDto) {
        YhUser yhUser = BeanUtil.toBean(userDto, YhUser.class);
        yhUserService.updateById(yhUser);
        yhUserRoleMapper
                .delete(Wrappers.<YhUserRole>update().lambda().eq(YhUserRole::getUserId, userDto.getUserId()));
        userDto.getRoleIds().stream().map(roleId -> {
            YhUserRole yhUserRole = new YhUserRole();
            yhUserRole.setUserId(yhUser.getUserId());
            yhUserRole.setRoleId(roleId);
            return yhUserRole;
        }).forEach(yhUserRoleMapper::insert);
        return ApiResult.success(yhUser.getUserId());
    }

    @PostMapping("/del")
    public ApiResult<Long> del(@RequestBody UserDTO userDto) {
        if (userDto.getUserId() != null) {
            yhUserService.removeById(userDto.getUserId());
        }
        return ApiResult.success();
    }

    @PostMapping("/getById")
    public ApiResult<UserVo> getById(@RequestBody UserDTO userDto) {
        if (userDto.getUserId() != null) {
            YhUser yhUser = yhUserService.getById(userDto.getUserId());
            UserVo userVo = BeanUtil.toBean(yhUser, UserVo.class);
            List<YhUserRole> yhUserRoles = yhUserRoleMapper.selectList(Wrappers.<YhUserRole>lambdaQuery().eq(YhUserRole::getUserId, userDto.getUserId()));
            List<Long> roleIds = yhUserRoles.stream().map(YhUserRole::getRoleId).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(roleIds)) {
                List<YhRole> yhRoles = yhRoleService.listByIds(roleIds);
                List<RoleVo> collect = yhRoles.stream().map(e ->
                        BeanUtil.toBean(e, RoleVo.class)
                ).collect(Collectors.toList());
                userVo.setRoleVos(collect);
            }
            return ApiResult.success(userVo);
        }
        return ApiResult.success();
    }


    @PostMapping("/findByUserName")
    public UserVo findByUserName(@RequestParam("userName") String userName) {
        YhUser yhUser = yhUserService.getOne(Wrappers.<YhUser>lambdaQuery().eq(YhUser::getUserName, userName));
        if (yhUser != null) {
            UserVo userVo = BeanUtil.toBean(yhUser, UserVo.class);
            List<YhUserRole> yhUserRoles = yhUserRoleMapper.selectList(Wrappers.<YhUserRole>lambdaQuery().eq(YhUserRole::getUserId, userVo.getUserId()));
            List<Long> roleIds = yhUserRoles.stream().map(YhUserRole::getRoleId).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(roleIds)) {
                List<YhRole> yhRoles = yhRoleService.listByIds(roleIds);
                List<RoleVo> collect = yhRoles.stream().map(e ->
                        BeanUtil.toBean(e, RoleVo.class)
                ).collect(Collectors.toList());
                userVo.setRoleVos(collect);
                return userVo;
            }
        }
        return null;
    }
}
