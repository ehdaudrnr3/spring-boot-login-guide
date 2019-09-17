package com.spring.login.guide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/")
	public ModelAndView index(ModelAndView model) {
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model) {
		model.setViewName("login");
		return model;
	}
}
