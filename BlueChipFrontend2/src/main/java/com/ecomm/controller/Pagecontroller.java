package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Pagecontroller 
{
	@RequestMapping(value="/login")
	public String showLoginPage(Model m)
	{
		m.addAttribute("title", "Login Page");
		return "Login";
	}

	@RequestMapping(value="/register")
	public String showRegisterPage(Model m)
	{
		m.addAttribute("title", "Register Page");
		return "Register";
	}
}
