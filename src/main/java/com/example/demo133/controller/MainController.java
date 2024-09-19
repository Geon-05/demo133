package com.example.demo133.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main() {
        return "/index";
    }
    
    @GetMapping("/test")
    public String test() {
        return "/common/template";
    }
    
    @GetMapping("/error404")
    public String error_code404() {
        return "/common/404";
    }
    
    
}
