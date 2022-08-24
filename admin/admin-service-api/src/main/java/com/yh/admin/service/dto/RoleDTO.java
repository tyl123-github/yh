package com.yh.admin.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色DTO
 *
 * @author yl_tao
 * @date 2022/5/16 22:05
 */
@Data
public class RoleDTO implements Serializable {

    /**
     * 搜索关键字
     */
    private String kw;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色代码标识
     */
    private String roleCode;

    /**
     * 角色描述
     */
    private String roleDescription;

}
