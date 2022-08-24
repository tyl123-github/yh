package com.yh.admin.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author yl_tao
 * @date 2022/5/14 11:55
 */
@Data
public class UserDTO implements Serializable {

    /**
     * 用户搜索框
     */
    private String kw;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 角色ID
     */
    private List<Long> roleIds;

}
