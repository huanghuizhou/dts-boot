package com.hhz.demo.model;

import java.io.Serializable;

public class TEmployeeDepartmentRelation implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 部门id
     *
     * @mbggenerated
     */
    private Long departmentId;
    /**
     * 员工id
     *
     * @mbggenerated
     */
    private Long employeeId;
    /**
     * 员工类型(一般/主管)
     *
     * @mbggenerated
     */
    private Byte employeeType;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Byte getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Byte employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", departmentId=").append(departmentId);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", employeeType=").append(employeeType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}