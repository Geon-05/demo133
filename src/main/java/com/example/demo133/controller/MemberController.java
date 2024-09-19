package com.example.demo133.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo133.dto.SearchDto;
import com.example.demo133.service.MemberService;


@Controller
public class MemberController {
    @Autowired
    MemberService service;

    @GetMapping("/member/memberList")
    public String list(SearchDto searchDto, Model model) {
        Map<String, Object> map = service.selectMemberList(searchDto);
        model.addAttribute("map", map);

        return "/member/list";
    }
    
}
