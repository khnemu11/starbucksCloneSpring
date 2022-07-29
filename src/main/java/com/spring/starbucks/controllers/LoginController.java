package com.spring.starbucks.controllers;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.PeopleServiceScopes;
import com.google.api.services.people.v1.model.ListConnectionsResponse;
import com.google.api.services.people.v1.model.Name;
import com.google.api.services.people.v1.model.Person;
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
		try {
			 URL url = new URL(requestUrl);
			 HttpURLConnection con = (HttpURLConnection) url.openConnection();
		     JSONObject jsonObject =(JSONObject)jsonParser.parse(new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8")));
		     System.out.println(jsonObject.toString());
		     
		     
		    
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
			} catch (MalformedURLException e) {
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
