package com.assimilate.springboot.web.security.controllers;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assimilate.springboot.web.security.model.User;
import com.assimilate.springboot.web.security.services.UserService;


@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login() 
	{
		System.out.println("In login page");
		return "login";
	}
	
	@RequestMapping(path = "/dologin", method=RequestMethod.POST)
	public String dologin()
	{
	
		System.out.println("In Submitt page");
		return "getAll";
		
	}
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String register(Model model)
	{
		model.addAttribute("command", new User());
		
		return "register";
	}
	
	@RequestMapping(path="/registert",method=RequestMethod.POST)
	public String save(@ModelAttribute User user)
	{
		  userService.createUser(user);
		  
		  return "redirect:/login";
	}
	
	
	
}
