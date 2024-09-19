package com.example.demo133;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    HttpSession session = request.getSession();
    String loginId = (String) session.getAttribute("loginId");
    String loginName = (String) session.getAttribute("loginName");

    if (loginId != null && modelAndView != null) {
      modelAndView.addObject("loginId", loginId);
      modelAndView.addObject("loginName", loginName);
    }
  }
}
