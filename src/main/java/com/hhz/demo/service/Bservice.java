package com.hhz.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bservice {

    @Autowired
    private Cservice cservice;

    public void bbb() {
        cservice.ccc();
        System.out.println("aaaa");
    }
}
