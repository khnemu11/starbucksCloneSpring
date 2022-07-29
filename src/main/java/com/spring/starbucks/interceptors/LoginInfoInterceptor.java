package com.spring.starbucks.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.starbucks.beans.UserBean;

public class LoginInfoInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		 	HttpSession session = request.getSession(); 
		 	UserBean user = new UserBean();
		 	if(session.getAttribute("login") != null) {
		 		user = (UserBean)session.getAttribute("login"); 
		 	} 
		 	modelAndView.addObject("loginInfo", user);
	}
}
