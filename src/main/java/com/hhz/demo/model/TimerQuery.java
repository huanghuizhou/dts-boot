package com.hhz.demo.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TimerQuery {

    String timerName;

    String topic;
    String describe;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeBeg;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeEnd;

    public String getTimerName() {
        return timerName;
    }

    public void setTimerName(String timerName) {
        this.timerName = timerName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getTimeBeg() {
        return timeBeg;
    }

    public void setTimeBeg(Date timeBeg) {
        this.timeBeg = timeBeg;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }
}

