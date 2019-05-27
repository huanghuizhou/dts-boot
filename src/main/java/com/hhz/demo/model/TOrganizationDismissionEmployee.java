package com.hhz.demo.model;

import java.io.Serializable;
import java.util.Date;

public class TOrganizationDismissionEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 组织id
     *
     * @mbggenerated
     */
    private Long organizationId;
    /**
     * 工号
     *
     * @mbggenerated
     */
    private String jobId;
    /**
     * 手机号
     *
     * @mbggenerated
     */
    private String phoneNumber;
    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String name;
    /**
     * 离职原因
     *
     * @mbggenerated
     */
    private String dismissionReason;
    /**
     * 离职时间
     *
     * @mbggenerated
     */
    private Date dismissionTime;
    private Date createTime;
    private Date modifyTime;

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

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDismissionReason() {
        return dismissionReason;
    }

    public void setDismissionReason(String dismissionReason) {
        this.dismissionReason = dismissionReason;
    }

    public Date getDismissionTime() {
        return dismissionTime;
    }

    public void setDismissionTime(Date dismissionTime) {
        this.dismissionTime = dismissionTime;
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
        sb.append(", id=").append(id);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", jobId=").append(jobId);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", name=").append(name);
        sb.append(", dismissionReason=").append(dismissionReason);
        sb.append(", dismissionTime=").append(dismissionTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}