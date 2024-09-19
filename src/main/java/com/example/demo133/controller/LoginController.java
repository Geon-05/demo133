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
            MemberDto member, @RequestParam(name = "chkIdSave", required = false) String chkIdSave,
            HttpServletResponse response, HttpSession session, Model model) {
        Cookie cookie = new Cookie("cookie_id", member.getId());
        cookie.setPath("/");

        if ("1".equals(chkIdSave)) {
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

    @GetMapping("/login/loginRegister")
    public String loginRegister() {
        return "/login/register";
    }

    @PostMapping("/login/loginRegisterAction")
    public String loginRegisterAction(
            MemberDto member, Model model) {
        int res = service.insertUser(member);

        if (res > 0) {
            model.addAttribute("msg", "환영합니다!\n로그인 후 이용이 가능합니다.");
            model.addAttribute("url", "/login/login");
            return "/common/msg";
        } else {
            model.addAttribute("msg", "회원가입 중 예외가 발생하였습니다.\n관리자에게 문의하세요.");
            return "/common/msg";
        }
    }

    @GetMapping("/login/logout")
    public String getMethodName(HttpSession session) {
        session.invalidate();
        return "redirect:/login/login";
    }
}
