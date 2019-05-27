package com.hhz.demo.model;

import java.io.Serializable;
import java.util.Date;

public class TDepartmentApply implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 账号id
     *
     * @mbggenerated
     */
    private Long accountId;
    /**
     * 申请团队id
     *
     * @mbggenerated
     */
    private Long organizationId;
    /**
     * 申请状态
     *
     * @mbggenerated
     */
    private Byte applyStatus;
    /**
     * 申请时间
     *
     * @mbggenerated
     */
    private Date applyTime;
    private Date createTime;
    private Date modifyTime;

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

    public Byte getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Byte applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
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
        sb.append(", accountId=").append(accountId);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", applyStatus=").append(applyStatus);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}