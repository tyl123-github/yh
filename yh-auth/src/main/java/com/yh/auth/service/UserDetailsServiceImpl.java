package com.yh.auth.service;

import cn.hutool.core.collection.CollectionUtil;
import com.yh.admin.service.feign.UserClient;
import com.yh.admin.service.vo.RoleVo;
import com.yh.admin.service.vo.UserVo;
import com.yh.common.core.utils.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author yl_tao
 * @date 2022/5/26 11:10
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserClient userClient;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("进入自定义授权接口");
        UserVo userVo = userClient.findByUserName(username);
        if (userVo == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<RoleVo> roleVos = userVo.getRoleVos();
        if (CollectionUtil.isEmpty(roleVos)){
            throw new UsernameNotFoundException("当前用户无权限信息");
        }
        List<SimpleGrantedAuthority> collect = roleVos.stream().map(e ->
                new SimpleGrantedAuthority("ROLE_" + e.getRoleCode())
        ).collect(Collectors.toList());
        //根据用户名数据库获取用户信息
        //查询用户所拥有的权限
        //返回user用户
        //返回当前用户
        return new MyUser(username,userVo.getPassword(), collect);
    }
}
