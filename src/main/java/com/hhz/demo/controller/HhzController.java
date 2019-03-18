package com.hhz.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Api(value = "demo", description = "demo详情")
@RestController
public class HhzController {

    @ApiOperation(value = "测试", notes = "city1")
    @GetMapping(value = "test")
    public Mono<List> listAll() throws InterruptedException {
        List a = new ArrayList();
        a.add("1234");
        a.add("a123");
        a.add("777");
        //Thread.sleep(3000);
        Mono.just(a);
        return Mono.just(a);
    }

    @ApiOperation(value = "测试1", notes = "city1")
    @GetMapping(value = "test1")
    public Mono<List> listAll1() throws InterruptedException {
        List a = new ArrayList();
        a.add("1234");
        a.add("666");
        //Thread.sleep(3000);
        Mono.just(a);
        return Mono.just(a);
    }
}
