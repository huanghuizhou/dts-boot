package com.hhz.demo.model;

import java.io.Serializable;

public class TOrganizationManager implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 员工id
     *
     * @mbggenerated
     */
    private Long employeeId;
    /**
     * 团队id
     *
     * @mbggenerated
     */
    private Long organizationId;
    /**
     * 权限类型
     *
     * @mbggenerated
     */
    private Byte authType;
    /**
     * 管理范围
     *
     * @mbggenerated
     */
    private String chargeRange;
    /**
     * 权限模型
     *
     * @mbggenerated
     */
    private String authModel;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Byte getAuthType() {
        return authType;
    }

    public void setAuthType(Byte authType) {
        this.authType = authType;
    }

    public String getChargeRange() {
        return chargeRange;
    }

    public void setChargeRange(String chargeRange) {
        this.chargeRange = chargeRange;
    }

    public String getAuthModel() {
        return authModel;
    }

    public void setAuthModel(String authModel) {
        this.authModel = authModel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", authType=").append(authType);
        sb.append(", chargeRange=").append(chargeRange);
        sb.append(", authModel=").append(authModel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}