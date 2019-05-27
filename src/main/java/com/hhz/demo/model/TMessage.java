package com.hhz.demo.model;

import java.io.Serializable;
import java.util.Date;

public class TMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 消息类型(个推消息/群发消息)
     *
     * @mbggenerated
     */
    private Byte messageType;
    /**
     * 消息状态
     *
     * @mbggenerated
     */
    private Byte status;
    private Date createTime;
    private Date modifyTime;
    /**
     * 消息源
     *
     * @mbggenerated
     */
    private String messageFrom;
    /**
     * 消息接收者
     *
     * @mbggenerated
     */
    private String messageTo;
    /**
     * 消息内容
     *
     * @mbggenerated
     */
    private String messageContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(String messageFrom) {
        this.messageFrom = messageFrom;
    }

    public String getMessageTo() {
        return messageTo;
    }

    public void setMessageTo(String messageTo) {
        this.messageTo = messageTo;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", messageType=").append(messageType);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", messageFrom=").append(messageFrom);
        sb.append(", messageTo=").append(messageTo);
        sb.append(", messageContent=").append(messageContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}