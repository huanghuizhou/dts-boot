package com.hhz.demo.model;

import java.io.Serializable;
import java.util.Date;

public class TOrganizationManagerOperationLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 组织id
     *
     * @mbggenerated
     */
    private Long organizationId;
    /**
     * 员工id
     *
     * @mbggenerated
     */
    private Long employeeId;
    /**
     * 操作时间
     *
     * @mbggenerated
     */
    private Date operateTime;
    /**
     * 操作类型
     *
     * @mbggenerated
     */
    private Byte operateType;
    /**
     * 详细数据
     *
     * @mbggenerated
     */
    private String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", operateTime=").append(operateTime);
        sb.append(", operateType=").append(operateType);
        sb.append(", details=").append(details);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}