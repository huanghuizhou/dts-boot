package com.hhz.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p class="detail">
 * 功能:测试spring 循环依赖问题
 * </p>
 *
 * @author HuangHuizhou
 * @ClassName Aservice.
 * @Version V1.0.
 * @date 2019.06.13 10:30:36
 */
@Service
public class Aservice {

    @Autowired
    private Bservice bservice;


    /**
     * <p class="detail">
     * 功能:
     * </p>
     *
     * @author huanghuizhou
     * @date 2019.06.13 10:30:36
     */
    public void aaa() {
        bservice.bbb();
        System.out.println("aaaa");
    }
}
