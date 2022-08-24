package com.yh.admin.service.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户vo
 *
 * @author yl_tao
 * @date 2022/5/16 23:24
 */
@Data
public class UserVo implements Serializable {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 服务商id
     */
    private Long tenantId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户绑定手机号
     */
    private String mobile;

    /**
     * 头像
     */
    private String profilePhoto;

    /**
     * 用户状态 0正常  9锁定
     */
    private String lockFlag;

    /**
     * 删除标记 0-未删除  1-已删除
     */
    private String deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建者
     */
    private Long createByName;

    /**
     * 修改者
     */
    private Long updateByName;

    /**
     * 角色ids
     */
    private List<RoleVo> roleVos;

}
