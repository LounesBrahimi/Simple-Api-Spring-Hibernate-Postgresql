package com.webapphibernate.webapphibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webapphibernate.webapphibernate.entity.User;
import com.webapphibernate.webapphibernate.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String home(Model model) {
	   Iterable<User> listUsers = service.getUsers();
	   model.addAttribute("users", listUsers);
	    return "home";
	}
	
	@GetMapping("/registreUser")
	public String registreUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "formNewUser";
	}
	
	@PostMapping("/saveUser")
	public ModelAndView saveEmployee(@ModelAttribute User user) {
		service.registreUsers(user);
		return new ModelAndView("redirect:/");	
	}
}
