package com.hhz.demo.model.timer;

import java.util.List;

/**
 * <p class="detail">
 * 功能:执行者
 * </p>
 *
 * @author huanghuizhou
 * @ClassName Executor.
 * @Version V1.0.
 * @date 2018.04.20 08:55:23
 */
public class Executor {
    private List<TopicInfo> topicInfos;
    private String lastExpectTime;

    public List<TopicInfo> getTopicInfos() {
        return topicInfos;
    }

    public void setTopicInfos(List<TopicInfo> topicInfos) {
        this.topicInfos = topicInfos;
    }

    public String getLastExpectTime() {
        return lastExpectTime;
    }

    public void setLastExpectTime(String lastExpectTime) {
        this.lastExpectTime = lastExpectTime;
    }
}
