package com.yh.admin.service.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yh.admin.service.dto.RoleDTO;
import com.yh.admin.service.entity.YhRole;
import com.yh.admin.service.service.YhRoleService;
import com.yh.common.core.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色管理
 *
 * @author yl_tao
 * @date 2022/5/16 22:03
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@Slf4j
public class YhRoleController {

    private final YhRoleService yhRoleService;

    /**
     * 功能描述: 角色新增接口
     *
     * @param roleDTO 角色信息
     * @return 返回角色id
     * @author yl_tao
     * @date 2022/5/16 22:09
     */
    @PostMapping("/list")
    public ApiResult<List<YhRole>> list(@RequestBody RoleDTO roleDTO) {
        LambdaQueryWrapper<YhRole> queryWrapper = Wrappers.<YhRole>lambdaQuery()
                .nested(StrUtil.isNotBlank(roleDTO.getKw()),
                        i -> i.like(YhRole::getRoleName, roleDTO.getKw())
                                .or()
                                .like(YhRole::getRoleCode, roleDTO.getKw()));
        List<YhRole> list = yhRoleService.list(queryWrapper);
        return ApiResult.success(list);
    }

    /**
     * 功能描述: 角色新增接口
     *
     * @param roleDTO 角色信息
     * @return 返回角色id
     * @author yl_tao
     * @date 2022/5/16 22:09
     */
    @PostMapping("/save")
    public ApiResult<Long> save(@RequestBody RoleDTO roleDTO) {
        YhRole yhRole = BeanUtil.toBean(roleDTO, YhRole.class);
        yhRoleService.save(yhRole);
        return ApiResult.success(yhRole.getRoleId());
    }

    /**
     * 功能描述: 角色编辑接口
     *
     * @param roleDTO 角色信息
     * @return 返回角色id
     * @author yl_tao
     * @date 2022/5/16 22:09
     */
    @PostMapping("/update")
    public ApiResult<Long> update(@RequestBody RoleDTO roleDTO) {
        YhRole yhRole = BeanUtil.toBean(roleDTO, YhRole.class);
        yhRoleService.updateById(yhRole);
        return ApiResult.success(yhRole.getRoleId());
    }

    /**
     * 功能描述: 获取角色详情信息
     *
     * @param roleDTO 角色信息
     * @return 返回角色id
     * @author yl_tao
     * @date 2022/5/16 22:09
     */
    @PostMapping("/getById")
    public ApiResult<YhRole> getById(@RequestBody RoleDTO roleDTO) {
        YhRole yhRole = yhRoleService.getById(roleDTO.getRoleId());
        return ApiResult.success(yhRole);
    }
    /**
     * 功能描述: 角色删除接口
     *
     * @param roleDTO 角色信息
     * @return 返回结果空
     * @author yl_tao
     * @date 2022/5/16 22:09
     */
    @PostMapping("/removeById")
    public ApiResult<Long> removeById(@RequestBody RoleDTO roleDTO) {
        yhRoleService.removeById(roleDTO.getRoleId());
        return ApiResult.success();
    }

}
