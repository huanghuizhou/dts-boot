package com.hhz.demo.model.timer;

/**
 * <p class="detail">
 * 功能:定时器基本信息
 * </p>
 *
 * @author huanghuizhou
 * @ClassName Timer entity.
 * @Version V1.0.
 * @date 2018.04.18 09:19:24
 */
public class TimerEntity {

    private String _id;

    /**
     * 唯一标示(不可更改，就是kafka topic，格式timer_xxx)
     */
    private String topic;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String describe;
    /**
     * cron表达式
     */
    private String corn;
    /**
     * kafka message
     */
    private String message;
    /**
     * 是否启用（true：启用 false：停用）
     */
    private Boolean status;

    /**
     * 创建日期
     */
    private String createTime;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCorn() {
        return corn;
    }

    public void setCorn(String corn) {
        this.corn = corn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
