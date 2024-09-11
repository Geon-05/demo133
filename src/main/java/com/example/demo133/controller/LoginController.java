package com.example.demo133.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo133.dto.MemberDto;
import com.example.demo133.service.LoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class LoginController {
    @Autowired
    LoginService service;

    @GetMapping("/login/login")
    public String login() {
        return "/login/login";
    }
    
    @PostMapping("/login/loginAction")
    public String loginAction(
        MemberDto member
        , @RequestParam(name = "chkIdSave", required = false) String chkIdSave
        , HttpServletResponse response
        , HttpSession session
        , Model model
    ) {
        Cookie cookie = new Cookie("cookie_id", member.getId());
        cookie.setPath("/");

        if ("save".equals(chkIdSave)) {
            cookie.setMaxAge(60 * 60 * 24 * 7);
        } else {
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);

        MemberDto loginMember = service.login(member);

        if (loginMember != null) {
            session.setAttribute("loginId", loginMember.getId());
            session.setAttribute("loginName", loginMember.getName());

            return "redirect:/book/bookList";
        } else {
            model.addAttribute("msg", "아이디 비밀번호를 확인해주세요.");

            return "/common/msg";
        }
    }
    
}
