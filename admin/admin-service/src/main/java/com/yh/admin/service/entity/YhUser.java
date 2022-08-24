package com.yh.admin.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户信息表
 * @TableName yh_user
 */
@TableName(value ="yh_user")
@Data
public class YhUser implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        YhUser other = (YhUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getProfilePhoto() == null ? other.getProfilePhoto() == null : this.getProfilePhoto().equals(other.getProfilePhoto()))
            && (this.getLockFlag() == null ? other.getLockFlag() == null : this.getLockFlag().equals(other.getLockFlag()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateByName() == null ? other.getCreateByName() == null : this.getCreateByName().equals(other.getCreateByName()))
            && (this.getUpdateByName() == null ? other.getUpdateByName() == null : this.getUpdateByName().equals(other.getUpdateByName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getProfilePhoto() == null) ? 0 : getProfilePhoto().hashCode());
        result = prime * result + ((getLockFlag() == null) ? 0 : getLockFlag().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateByName() == null) ? 0 : getCreateByName().hashCode());
        result = prime * result + ((getUpdateByName() == null) ? 0 : getUpdateByName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", userName=").append(userName);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", mobile=").append(mobile);
        sb.append(", profilePhoto=").append(profilePhoto);
        sb.append(", lockFlag=").append(lockFlag);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createByName=").append(createByName);
        sb.append(", updateByName=").append(updateByName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}