package com.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

	@Controller
	public class RegisterController
	{
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@RequestParam("username")String username,@RequestParam("address")String address,@RequestParam("emailId")String emailId,@RequestParam("moblieNo")String moblieNo,@RequestParam("password")String password,Model m)
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setUsername(username);
		userDetail.setAddress(address);
		userDetail.setEmailId(emailId);
	
		
		userDetail.setMoblieNo(moblieNo);
		userDetail.setPassword(password);
		userDetail.setRole("ROLE_USER");
		userDetail.setEnabled(true);
		userDAO.registerUser(userDetail);
		return "Login";
	}
	
	
	
	
	
	}