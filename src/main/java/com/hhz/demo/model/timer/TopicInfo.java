package com.hhz.demo.model.timer;

import org.apache.zookeeper.data.Stat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p class="detail">
 * 功能:执行者信息（groupID 和上次实际执行时间）
 * </p>
 *
 * @author huanghuizhou
 * @ClassName Topic info.
 * @Version V1.0.
 * @date 2018.04.20 08:53:18
 */
public class TopicInfo {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String consumer;
    private Stat stat;
    private String lastTime;


    public TopicInfo(String consumer, Stat stat) {
        this.consumer = consumer;
        this.stat = stat;
        Date date = new Date();
        date.setTime(stat.getMtime());
        this.lastTime = dateFormat.format(date);
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
