package com.hhz.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Cservice {

    @Autowired
    private Aservice aservice;

    public void ccc() {
        aservice.aaa();
        System.out.println("aaaa");
    }
}
