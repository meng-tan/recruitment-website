package com.csye6220.recruitment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csye6220.recruitment.dao.AdminDAO;
import com.csye6220.recruitment.dao.HrDAO;
import com.csye6220.recruitment.dao.RoleDAO;
import com.csye6220.recruitment.dao.UserDAO;
import com.csye6220.recruitment.pojo.Admin;
import com.csye6220.recruitment.pojo.Hr;
import com.csye6220.recruitment.pojo.Role;
import com.csye6220.recruitment.pojo.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private HrDAO hrDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
    @Autowired  
    private BCryptPasswordEncoder bcryptEncoder;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	protected String showRegisterForm(){
		return "register-user";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	protected String handleRegisterForm(HttpServletRequest request,ModelMap model){
		try {
			String username = request.getParameter("username");
			String rawPassword = request.getParameter("password");
			String password = bcryptEncoder.encode(rawPassword);
			String roleString = request.getParameter("role");
			Role role = roleDAO.getByName(roleString);
			if(roleString.equals("ROLE_USER")) {
				User user = new User(username,password,role);
				userDAO.add(user);
			}else if(roleString.equals("ROLE_HR")) {
				Hr hr = new Hr(username,password,role);
				hrDAO.add(hr);
			}
			return "login-page";
		} catch (Exception e) {
			model.addAttribute("errorMessage","error while registering a new user");
			return "error-page";
		}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginFrom() {
		System.out.println("get login");
		return "login-page";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String DispatcherUser(HttpServletRequest request,ModelMap model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		System.out.println("dispatcher test role:"+userDetails.getAuthorities().toString());
		
		HttpSession session = request.getSession();
		switch(userDetails.getAuthorities().toString()) {
		case "[ROLE_USER]":
			User user = userDAO.get(userDetails.getUsername());
			session.setAttribute("user", user);
			model.addAttribute("user", user);
			return "redirect:/user/user-home";
		case "[ROLE_HR]":
			Hr hr = hrDAO.get(userDetails.getUsername());
			session.setAttribute("hr", hr);
			model.addAttribute("hr", hr);
			return "redirect:/hr/hr-home";
		case "[ROLE_ADMIN]":
			Admin admin = adminDAO.get(userDetails.getUsername());
			session.setAttribute("admin", admin);
			model.addAttribute("admin", admin);
			return "redirect:/admin/admin-home";
		default:
			break;	
		}
		model.addAttribute("errorMessage", "user does not exist");
		return "error-page";
	}
	
	@RequestMapping(value="/user/user-home",method=RequestMethod.GET)
	public String showUserHome() {
		return "user-home";
	}
	
	@RequestMapping(value="/hr/hr-home",method=RequestMethod.GET)
	public String showHrHome(HttpServletRequest request, ModelMap model) {
		System.out.println("redirected");
		return "hr-home";
	}
	
	@RequestMapping(value="/admin/admin-home",method=RequestMethod.GET)
	public String showAdminHome(HttpServletRequest request, ModelMap model) {
		return "admin-home";
	}
	
	@RequestMapping(value="/**/accessDenied",method=RequestMethod.GET)
	public String accessDenied() {
		return "access-denied";
	}
	
}
