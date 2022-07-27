package com.spring.starbucks.controllers;


import java.io.UnsupportedEncodingException;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.starbucks.beans.Coffee;
import com.spring.starbucks.daos.CrudService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Resource(name = "crudService")
	CrudService crudService;
	int test = 2;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Coffee> coffeeList = crudService.getAllRecords();

		model.addAttribute("list", coffeeList);

		return "index";
	}

	@RequestMapping(value = "/addcoffeeform", method = RequestMethod.GET)
	public String addCoffeeForm(Locale locale, Model model) {
		return "addcoffeeform";
	}

	@RequestMapping(value = "/addcoffee", method = RequestMethod.POST)
	public String addCoffee(Locale locale, MultipartHttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println(request.getParameter("name_kr"));
		String directory = request.getServletContext().getRealPath("resources/img/coffee_bean");
		System.out.println("real path : " + directory);
		
		Coffee c = new Coffee();
		
		c.setName_kr(request.getParameter("name_kr"));
		c.setName_en(request.getParameter("name_en"));
		c.setType(request.getParameter("type"));
		c.setDescription_summary(request.getParameter("description_summary"));
		c.setDescription_detail(request.getParameter("description_detail"));
		c.setDesign_story(request.getParameter("design_story"));
		c.setCoffee_tasting_note(request.getParameter("coffee_tasting_note"));
		c.setTasting_notes(request.getParameter("tasting_notes"));
		c.setEnjoy_with(request.getParameter("enjoy_with"));
		c.setRelative(request.getParameter("relative"));
		  
		MultipartFile file=request.getFile("file");
		c.setFile(file);  
		 
		crudService.save(c,directory);
		
		return "addcoffeeform";
	}
	@RequestMapping(value = "/editCoffeeBean", method = RequestMethod.POST)
	public String editCoffeeBean(Locale locale,Model model, MultipartHttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("name_kr"));
		String directory = request.getServletContext().getRealPath("resources/img/coffee_bean");
		System.out.println("real path : " + directory);
		
		Coffee c = new Coffee();
		
		c.setSeq(Long.valueOf(request.getParameter("seq")));
		c.setName_kr(request.getParameter("name_kr"));
		c.setName_en(request.getParameter("name_en"));
		c.setType(request.getParameter("type"));
		c.setDescription_summary(request.getParameter("description_summary"));
		c.setDescription_detail(request.getParameter("description_detail"));
		c.setDesign_story(request.getParameter("design_story"));
		c.setCoffee_tasting_note(request.getParameter("coffee_tasting_note"));
		c.setTasting_notes(request.getParameter("tasting_notes"));
		c.setEnjoy_with(request.getParameter("enjoy_with"));
		c.setRelative(request.getParameter("relative"));
		  
		MultipartFile file=request.getFile("file");
		System.out.println("input file "+file.getOriginalFilename());
		c.setFile(file);  
		 
		System.out.println(file.getOriginalFilename());
		int status = crudService.edit(c,directory);
		if(status==0) {
			return "redirect:coffeeBeanDetail?seq="+c.getSeq();
		}
		else {
			return "redirect:editCoffeeBeanForm?seq="+c.getSeq();
		}
	}
	@RequestMapping(value = "/editCoffeeBeanForm", method = RequestMethod.GET)
	public String editCoffeeBeanForm(Locale locale, Model model, HttpServletRequest request) {
		int seq = Integer.valueOf(request.getParameter("seq"));
		System.out.println("Seq : "+seq);
		Coffee coffee = crudService.getRecordBySeq(seq);
		
		model.addAttribute("coffee",coffee);
		
		return "editCoffeeBeanForm";
	}
	
	
	@RequestMapping(value = "/coffeeBeanDetail", method = RequestMethod.GET)
	public String detailCoffeeBean(Locale locale, Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		int seq = Integer.valueOf(request.getParameter("seq"));
		System.out.println("Seq : "+seq);
		Coffee coffee = crudService.getRecordBySeq(seq);
		
		model.addAttribute("coffee",coffee);

		return "coffeeBeanDetail";
	}
	
	@RequestMapping(value = "/deleteCoffeeBean", method = RequestMethod.GET)
	public String deleteCoffeeBean(Locale locale, Model model,HttpServletRequest request){
		int seq = Integer.valueOf(request.getParameter("seq"));
		System.out.println("Seq : "+seq);
		int status = crudService.delete(seq);

		return "redirect:index";
	}

	public CrudService getCrudService() {
		return crudService;
	}

	public void setCrudService(CrudService crudService) {
		this.crudService = crudService;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}
}
