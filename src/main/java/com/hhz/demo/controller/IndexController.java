package com.hhz.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/")
public class IndexController {


    @RequestMapping()
    public String test2() {
        return "index";
    }

}
