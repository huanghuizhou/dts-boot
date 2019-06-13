package com.hhz.demo.controller;


import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller()
@RequestMapping("/redisson")
public class RedissonController {

    @Autowired
    private RedissonClient redissonClient;


    @RequestMapping("test1")
    @ResponseBody
    public String test1() {
        RLock aaa = redissonClient.getLock("aaa");
        aaa.lock(2, TimeUnit.MINUTES);
        return "index";
    }

    @RequestMapping("test2")
    @ResponseBody
    public String test2() {
        RLock aaa = redissonClient.getLock("aaa");
        aaa.lock(2, TimeUnit.MINUTES);
        return "index1";
    }
}
