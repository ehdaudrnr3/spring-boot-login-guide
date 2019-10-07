package com.spring.login.guide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.login.guide.models.User;
import com.spring.login.guide.service.UserService;

@Controller
public class UserController {
	
	private UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
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
	
	@RequestMapping(value = "/join")
	public ModelAndView join(ModelAndView model) {
		model.setViewName("join");
		return model;
	}
	
	@PostMapping("/create")
	public ModelAndView create(User user) {
		service.createUser(user);
		return new ModelAndView("redirect:/login");
		
	}
}
