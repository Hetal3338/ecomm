package com.ecomm.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDAOimpl;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

@Controller
public class UserController
{
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/login_success")
	public String loginSuccess(HttpSession session,Model m)
	{
		String page="";
		//This variable will check whether a user is logged in or anonymous|global
		boolean loggedIn=false;
		//SecurityContext object will contain all the information like username,role etc.
		//To get this object we need to call the getContext() method of SecurityContextHolder. 
		SecurityContext scontext=SecurityContextHolder.getContext();
		//We need to get the Authentication object from the SecurityContext object
		//This object has method which will get the username and role information.
		Authentication authentication=scontext.getAuthentication();
		
		
		//getName() method on Authentication object will return the username who is logged in.
		String username=authentication.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		List<Product>listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		List<Category> categoryList=categoryDAO.listCategory();
		session.setAttribute("categorylist", categoryList);
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			if(role.getAuthority().equals("ROLE_USER"))
			{
				loggedIn=true;
				page="UserHome";
				session.setAttribute("username", username);
				session.setAttribute("loggedIn", loggedIn);
				System.out.println("Role_user"+page);
			}
			else
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("usename", username);
				session.setAttribute("loggedIn", loggedIn);
				System.out.println("Role_admin"+page);
			}
		}
		
		
			 return page;
	}
	
}
