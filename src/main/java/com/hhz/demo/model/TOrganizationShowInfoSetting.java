package com.hhz.demo.model;

import java.io.Serializable;
import java.util.Date;

public class TOrganizationShowInfoSetting implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 团队id
     *
     * @mbggenerated
     */
    private Long departmentId;
    private Date modifyTime;
    private Date createTime;
    /**
     * 默认信息
     *
     * @mbggenerated
     */
    private String defaultInfo;
    /**
     * 可检索自定义信息
     *
     * @mbggenerated
     */
    private String sortableInfo;
    /**
     * 不可检索自定义信息
     *
     * @mbggenerated
     */
    private String customInfo;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDefaultInfo() {
        return defaultInfo;
    }

    public void setDefaultInfo(String defaultInfo) {
        this.defaultInfo = defaultInfo;
    }

    public String getSortableInfo() {
        return sortableInfo;
    }

    public void setSortableInfo(String sortableInfo) {
        this.sortableInfo = sortableInfo;
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
        sb.append(", departmentId=").append(departmentId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", defaultInfo=").append(defaultInfo);
        sb.append(", sortableInfo=").append(sortableInfo);
        sb.append(", customInfo=").append(customInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}