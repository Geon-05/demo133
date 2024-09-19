package com.example.demo133.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo133.service.LoginService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class LoginRestController {
    @Autowired
    LoginService service;

    @GetMapping("/checkId/{id}")
    public Map<String, Object> checkId(
            @PathVariable(name = "id") String id) {
        Map<String, Object> map = new HashMap<>();

        int res = service.selectCheckId(id);
        map.put("id_res", res);

        return map;
    }

}
