package com.example.demo133;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler)
      throws Exception {
    return true;
  }

  @Override
  public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler,
  @Nullable ModelAndView modelAndView) throws Exception {
    HttpSession session = request.getSession();
    String loginId = (String) session.getAttribute("loginId");
    String loginName = (String) session.getAttribute("loginName");

    if (loginId != null && modelAndView != null) {
      modelAndView.addObject("loginId", loginId);
      modelAndView.addObject("loginName", loginName);
    }
  }
}
