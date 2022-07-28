package com.spring.starbucks.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.starbucks.beans.UserBean;

public class LoginAuthenticationInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
				HttpSession session = request.getSession();
				if(session.getAttribute("login")!=null) {
					return true;
				}
				response.sendRedirect("/springStarbucks/loginForm");
				return false;
	}
}
