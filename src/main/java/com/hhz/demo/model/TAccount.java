package com.hhz.demo.model;

import java.io.Serializable;
import java.util.Date;

public class TAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 手机号码
     *
     * @mbggenerated
     */
    private String phoneNumber;
    /**
     * 头像
     *
     * @mbggenerated
     */
    private String photo;
    /**
     * 密码
     *
     * @mbggenerated
     */
    private String password;
    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String name;
    /**
     * 工作状态
     *
     * @mbggenerated
     */
    private Byte workStatus;
    /**
     * 性别
     *
     * @mbggenerated
     */
    private Boolean sex;
    /**
     * 生日
     *
     * @mbggenerated
     */
    private Date birthday;
    /**
     * 状态
     *
     * @mbggenerated
     */
    private Byte status;
    /**
     * 注册时间
     *
     * @mbggenerated
     */
    private Date registerTime;
    private Date createTime;
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Byte workStatus) {
        this.workStatus = workStatus;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
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
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", photo=").append(photo);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", workStatus=").append(workStatus);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", status=").append(status);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}