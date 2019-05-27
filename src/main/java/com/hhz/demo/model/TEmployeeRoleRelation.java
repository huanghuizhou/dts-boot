package com.hhz.demo.model;

import java.io.Serializable;

public class TEmployeeRoleRelation implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 员工id
     *
     * @mbggenerated
     */
    private Long employeeId;
    /**
     * 角色id
     *
     * @mbggenerated
     */
    private Long roleId;
    /**
     * 管理范围
     *
     * @mbggenerated
     */
    private String chargeRange;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getChargeRange() {
        return chargeRange;
    }

    public void setChargeRange(String chargeRange) {
        this.chargeRange = chargeRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", roleId=").append(roleId);
        sb.append(", chargeRange=").append(chargeRange);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}