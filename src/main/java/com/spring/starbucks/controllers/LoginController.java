package com.spring.starbucks.controllers;


import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;

import java.util.Locale;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.starbucks.beans.LoginBean;
import com.spring.starbucks.beans.UserBean;
import com.spring.starbucks.daos.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@Resource(name = "loginService")
	LoginService loginService;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = {"/loginForm"}, method = RequestMethod.GET)
	public String loginForm(Locale locale, Model model) {
		
		return "login/login";
	}
	@RequestMapping(value = {"/loginGoogle"}, method = RequestMethod.GET)
	@ResponseBody
	public UserBean loginGoogle(Locale locale, Model model,HttpServletRequest request,HttpSession session) throws IOException, ParseException, GeneralSecurityException {
		JSONParser jsonParser = new JSONParser();
	     String token = request.getParameter("token");
	     String requestUrl = "https://oauth2.googleapis.com/tokeninfo";
	     requestUrl += "?id_token="+token;
	     UserBean user = new UserBean();
	     JSONObject jsonObject = new JSONObject();
		try {
			 URL url = new URL(requestUrl);
			 HttpURLConnection con = (HttpURLConnection) url.openConnection();
		     jsonObject =(JSONObject)jsonParser.parse(new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8")));
		   //  System.out.println(jsonObject.toString());
		     
		     user = PeopleQuickstart.start((String)jsonObject.get("sub"));  
		     if(loginService.idCheck(user) == 0) {
		    	String result = loginService.register(user);
		 		if(result.equals("success")) {
		 			model.addAttribute("user", user);
		 			
		 			if(session.getAttribute("login")!=null) {
		 				session.removeAttribute("login");
		 			}
		 			session.setAttribute("login", user);
		 			
		 			System.out.println("google register success");
		 			return user;
		 		}
		 		else {
		 			System.out.println("google register fail");
		 			return null;
		 		} 
		     }
		     else {
		    	 UserBean result = loginService.login(user);
			 		if(result != null) {
			 			System.out.println("login success!");
			 			System.out.println(result.toString());
			 			if(session.getAttribute("login")!=null) {
			 				session.removeAttribute("login");
			 			}
			 			session.setAttribute("login", result);
			 		}
			 		
			 		System.out.println("login finish");
			 		
			 		return result;
		     }
			} catch (Exception e) {
				e.printStackTrace();
		}
		return user;
	}
	@RequestMapping(value = {"/loginApiFail"}, method = RequestMethod.GET)
	@ResponseBody
	public UserBean loginApiFail(Locale locale, Model model,HttpServletRequest request,HttpSession session) throws IOException, ParseException, GeneralSecurityException {
		System.out.println("loginApiFail start"); 
		JSONParser jsonParser = new JSONParser();
	     String token = request.getParameter("token");
	     String requestUrl = "https://oauth2.googleapis.com/tokeninfo";
	     requestUrl += "?id_token="+token;
	     UserBean user = new UserBean();
	     JSONObject jsonObject = new JSONObject();
	     System.out.println(token);
		try {
			 URL url = new URL(requestUrl);
			 HttpURLConnection con = (HttpURLConnection) url.openConnection();
		     jsonObject =(JSONObject)jsonParser.parse(new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8")));
		     System.out.println(jsonObject.toString());
		     
		     user.setId(String.valueOf(jsonObject.get("email")));
		     user.setName(String.valueOf(jsonObject.get("name")));
		     user.setPassword("google");
		     user.setYear(1900);
		     user.setMonth(0);
		     user.setDay(0);
		     user.setNickname(String.valueOf(jsonObject.get("name")));
		     user.setPhone("000-0000-0000");
		     user.setSex("M");
			     
		     
		     if(loginService.idCheck(user) == 0) {
		    	String result = loginService.register(user);
		 		if(result.equals("success")) {
		 			model.addAttribute("user", user);
		 			
		 			if(session.getAttribute("login")!=null) {
		 				session.removeAttribute("login");
		 			}
		 			session.setAttribute("login", user);
		 			
		 			System.out.println("google register success");
		 			return user;
		 		}
		 		else {
		 			System.out.println("google register fail");
		 			return null;
		 		} 
		     }
		     else {
		    	 UserBean result = loginService.login(user);
			 		if(result != null) {
			 			System.out.println("login success!");
			 			System.out.println(result.toString());
			 			if(session.getAttribute("login")!=null) {
			 				session.removeAttribute("login");
			 			}
			 			session.setAttribute("login", result);
			 		}
			 		
			 		System.out.println("login finish");
			 		
			 		return result;
		     }
			} catch (Exception e) {
				e.printStackTrace();
		}
		return user;
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

		return "register/register";
	}
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String register(Locale locale, Model model, UserBean user,HttpServletRequest request) {
		String result = loginService.register(user);
		
		if(result.equals("success")) {
			model.addAttribute("user", user);
			return "register/registerSuccess";
		}
		else {
			model.addAttribute("error", result);
			return "register/register";
		}
	}

	/*
	 * @RequestMapping(value = {"/registerSuccess"}, method = RequestMethod.GET)
	 * public String registerSuccess(Locale locale, Model model, UserBean user) {
	 * 
	 * 
	 * return "register/registerSuccess"; }
	 */
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logout(Locale locale, Model model,HttpSession session) {
		session.removeAttribute("login");
		
		
		return "redirect:index";

	}
}
