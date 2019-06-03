package com.hhz.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Aservice {

    @Autowired
    private Bservice bservice;

    @Autowired
    private Cservice cservice;

    public void aaa() {
        bservice.bbb();
        cservice.ccc();
        System.out.println("aaaa");
    }
}
