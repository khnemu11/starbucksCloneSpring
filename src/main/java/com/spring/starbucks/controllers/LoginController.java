package com.spring.starbucks.controllers;


import java.io.UnsupportedEncodingException;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.starbucks.beans.Coffee;
import com.spring.starbucks.beans.LoginBean;
import com.spring.starbucks.beans.UserBean;
import com.spring.starbucks.daos.CrudService;
import com.spring.starbucks.daos.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@Resource(name = "loginService")
	LoginService loginService;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/loginForm"}, method = RequestMethod.GET)
	public String loginForm(Locale locale, Model model) {
		
		return "login";
	}
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	@ResponseBody
	public UserBean login(Locale locale, Model model, HttpSession session ,LoginBean login) {
		System.out.println(login.toString());
		UserBean result = loginService.login(login);
		if(result != null) {
			System.out.println("login success!");
			if(session.getAttribute("login")!=null) {
				session.removeAttribute("login");
			}
			session.setAttribute("login", result);
		}
		System.out.println("login finish");
		return result;
	}
	@RequestMapping(value = {"/idCheck"}, method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(Locale locale, Model model, HttpSession session ,HttpServletRequest request) {
		UserBean user = new UserBean();
		user.setId(request.getParameter("id"));
		System.out.println("will be found id is "+user.getId());
		int result = loginService.idCheck(user);
		
		return String.valueOf(result);
	}
	@RequestMapping(value = {"/registerForm"}, method = RequestMethod.GET)
	public String registerForm(Locale locale, Model model) {

		return "register";
	}
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String register(Locale locale, Model model, UserBean user) {
		String result = loginService.register(user);
		
		if(result.equals("success")) {
			return "registerSuccess";
		}
		else {
			model.addAttribute("error", result);
			return "register";
		}
	}
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logout(Locale locale, Model model,HttpSession session) {
		session.removeAttribute("login");
		
		
		return "redirect:index";

	}
}
