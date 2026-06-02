package com.cb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gbm")
public class HelloController {

    @GetMapping("/hello0")
    public String hello() {
        return "JWT is working!";
    }

    //cretaed by amala
    
    @GetMapping("/report")
    public String getReportDtails() {
        return "Reposrt are working successfully!!!";
    }
    
    @GetMapping("/hello")
    public String doumloadPdf() {
        return "downloaded successfully!!!";
    }
}
