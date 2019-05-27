package com.hhz.demo.model;

import java.io.Serializable;
import java.util.Date;

public class TOrganizationRoleGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long roleGroupId;
    /**
     * 所属团队
     *
     * @mbggenerated
     */
    private Long organizationId;
    /**
     * 角色组名称
     *
     * @mbggenerated
     */
    private String roleGroupName;
    private Date createTime;
    private Date modifyTime;

    public Long getRoleGroupId() {
        return roleGroupId;
    }

    public void setRoleGroupId(Long roleGroupId) {
        this.roleGroupId = roleGroupId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getRoleGroupName() {
        return roleGroupName;
    }

    public void setRoleGroupName(String roleGroupName) {
        this.roleGroupName = roleGroupName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleGroupId=").append(roleGroupId);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", roleGroupName=").append(roleGroupName);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}