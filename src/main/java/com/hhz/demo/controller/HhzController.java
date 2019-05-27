package com.hhz.demo.controller;

import com.hhz.demo.dao.TAccountMapper;
import com.hhz.demo.dao.TMessageMapper;
import com.hhz.demo.dao.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "demo", description = "demo详情")
@RestController
public class HhzController {


    @Autowired
    private TAccountMapper tAccountMapper;


    @Autowired
    private TMessageMapper tMessageMapper;

    @Autowired
    private UserMapper userMapper;



    @ApiOperation(value = "测试333", notes = "city333")
    @GetMapping(value = "test2")
    public String listAll2() throws InterruptedException {
        return null;
    }

}
