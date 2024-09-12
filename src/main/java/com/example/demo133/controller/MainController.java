package com.example.demo133.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {
    @GetMapping("/")
    public String main() {
        return "/index";
    }
    
    @GetMapping("/test")
    public String getMethodName() {
        return "/common/template";
    }
    
}
