package com.gbm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gbm")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "JWT is working!";
    }
}
