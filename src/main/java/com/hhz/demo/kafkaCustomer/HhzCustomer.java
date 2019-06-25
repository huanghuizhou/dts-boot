package com.hhz.demo.kafkaCustomer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class HhzCustomer {

    /**
     * 监听test主题,有消息就读取
     *
     * @param message
     */
    @KafkaListener(topics = {"hhz"})
    public void consumer(String message) {
        System.out.println(message);
    }


}
