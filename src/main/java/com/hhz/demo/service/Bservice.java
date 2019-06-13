package com.hhz.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bservice {

    @Autowired
    private Aservice aservice;

    public void bbb() {
        System.out.println("aaaa");
    }

    public void ccc() {
        aservice.aaa();
        System.out.println("aaaa");
    }
}
