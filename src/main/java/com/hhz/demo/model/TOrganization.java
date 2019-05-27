package com.hhz.demo.model;

import java.io.Serializable;
import java.util.Date;

public class TOrganization implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 组织名称
     *
     * @mbggenerated
     */
    private String organizationName;
    /**
     * 组织类型(目前只有团队)
     *
     * @mbggenerated
     */
    private Byte organizationType;
    /**
     * 组织拥有者(主管理员)
     *
     * @mbggenerated
     */
    private Long organizationOwner;
    /**
     * 组织头像
     *
     * @mbggenerated
     */
    private String organizationPhoto;
    private Date createTime;
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Byte getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Byte organizationType) {
        this.organizationType = organizationType;
    }

    public Long getOrganizationOwner() {
        return organizationOwner;
    }

    public void setOrganizationOwner(Long organizationOwner) {
        this.organizationOwner = organizationOwner;
    }

    public String getOrganizationPhoto() {
        return organizationPhoto;
    }

    public void setOrganizationPhoto(String organizationPhoto) {
        this.organizationPhoto = organizationPhoto;
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
        sb.append(", organizationName=").append(organizationName);
        sb.append(", organizationType=").append(organizationType);
        sb.append(", organizationOwner=").append(organizationOwner);
        sb.append(", organizationPhoto=").append(organizationPhoto);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}