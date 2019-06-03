package com.hhz.demo.controller;

import com.hhz.demo.model.UserTest;
import com.hhz.demo.service.Aservice;
import com.hhz.demo.service.Bservice;
import com.hhz.demo.service.Cservice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "demo", description = "demo详情")
@RestController
public class HhzController {


    private static ThreadLocal<UserTest> LOCAL_USER = new ThreadLocal<>();
    @Autowired
    private Aservice aservice;
    @Autowired
    private Bservice bservice;
    @Autowired
    private Cservice cservice;

    @ApiOperation(value = "测试333", notes = "city333")
    @GetMapping(value = "test2")
    public UserTest listAll2() throws InterruptedException {
        UserTest userTest = LOCAL_USER.get();
        if (userTest == null) {
            userTest = new UserTest();
            userTest.setAge("aaaa");
            userTest.setId("asd");
            LOCAL_USER.set(userTest);
        }
        return userTest;
    }


    @ApiOperation(value = "aaa", notes = "aaa")
    @GetMapping(value = "aaa")
    public String aaa() {

        aservice.aaa();
        bservice.bbb();
        cservice.ccc();
        return "asd";
    }
}
