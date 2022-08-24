package com.yh.admin.service.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author yl_tao
 * @date 2022/5/16 23:34
 */
@Data
public class RoleVo implements Serializable {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 服务商id
     */
    private Long tenantId;

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

    /**
     * 创建人
     */
    private String createByName;

    /**
     * 修改人
     */
    private LocalDateTime updateByName;
}
