package com.hhz.demo.controller;

import com.hhz.demo.model.UserTest;
import com.hhz.demo.service.Aservice;
import com.hhz.demo.service.Bservice;
import com.hhz.demo.service.Cservice;
import com.hhz.demo.service.DepService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "test", description = "test详情")
@RestController
public class TestController {


    private static ThreadLocal<UserTest> LOCAL_USER = new ThreadLocal<>();
    @Autowired
    private Aservice aservice;
    @Autowired
    private Bservice bservice;
    @Autowired
    private Cservice cservice;
    @Autowired
    private DepService depService;

    @ApiOperation(value = "测试ThreadLocal", notes = "测试ThreadLocal")
    @GetMapping(value = "test1")
    public UserTest listAll2() {
        UserTest userTest = LOCAL_USER.get();
        if (userTest == null) {
            userTest = new UserTest();
            userTest.setAge("aaaa");
            userTest.setId("asd");
            LOCAL_USER.set(userTest);
        }
        return userTest;
    }

    @ApiOperation(value = "测试spring bean 循环依赖", notes = "测试spring bean 循环依赖")
    @GetMapping(value = "test2")
    public String aaa() {

        aservice.aaa();
        bservice.bbb();
        cservice.ccc();
        return "asd";
    }

    @ApiOperation(value = "测试mysql锁", notes = "测试mysql锁")
    @GetMapping(value = "test3")
    public String test3(String orgId) {
        depService.aaa(orgId);
        return "test3";
    }
}
