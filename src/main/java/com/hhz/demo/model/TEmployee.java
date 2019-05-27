package com.hhz.demo.model;

import java.io.Serializable;

public class TEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 员工id
     *
     * @mbggenerated
     */
    private Long id;
    /**
     * 账号id
     *
     * @mbggenerated
     */
    private Long accountId;
    /**
     * 组织id
     *
     * @mbggenerated
     */
    private Long organizationId;
    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String name;
    /**
     * 职位
     *
     * @mbggenerated
     */
    private String position;
    /**
     * 工号
     *
     * @mbggenerated
     */
    private String employeeNumber;
    /**
     * 邮箱
     *
     * @mbggenerated
     */
    private String mail;
    /**
     * 分机号
     *
     * @mbggenerated
     */
    private String telNumber;
    /**
     * 办公地点
     *
     * @mbggenerated
     */
    private String workPlace;
    /**
     * 入职日期
     *
     * @mbggenerated
     */
    private String entryTime;
    /**
     * 对外职称
     *
     * @mbggenerated
     */
    private String outerPosition;
    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remarks;
    /**
     * 可检索自定义信息
     *
     * @mbggenerated
     */
    private String sortableCustomInfo;
    /**
     * 不可检索自定义信息
     *
     * @mbggenerated
     */
    private String customInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getOuterPosition() {
        return outerPosition;
    }

    public void setOuterPosition(String outerPosition) {
        this.outerPosition = outerPosition;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSortableCustomInfo() {
        return sortableCustomInfo;
    }

    public void setSortableCustomInfo(String sortableCustomInfo) {
        this.sortableCustomInfo = sortableCustomInfo;
    }

    public String getCustomInfo() {
        return customInfo;
    }

    public void setCustomInfo(String customInfo) {
        this.customInfo = customInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", name=").append(name);
        sb.append(", position=").append(position);
        sb.append(", employeeNumber=").append(employeeNumber);
        sb.append(", mail=").append(mail);
        sb.append(", telNumber=").append(telNumber);
        sb.append(", workPlace=").append(workPlace);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", outerPosition=").append(outerPosition);
        sb.append(", remarks=").append(remarks);
        sb.append(", sortableCustomInfo=").append(sortableCustomInfo);
        sb.append(", customInfo=").append(customInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}