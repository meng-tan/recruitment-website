package com.csye6220.recruitment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csye6220.recruitment.dao.AdminDAO;
import com.csye6220.recruitment.dao.RoleDAO;
import com.csye6220.recruitment.pojo.Admin;
import com.csye6220.recruitment.pojo.Application;
import com.csye6220.recruitment.pojo.Hr;
import com.csye6220.recruitment.pojo.Post;
import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.pojo.Role;
import com.csye6220.recruitment.pojo.User;

@Controller
public class AdminController {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
    @Autowired  
    private BCryptPasswordEncoder bcryptEncoder;
	
	@RequestMapping(value="/admin/addAdmin",method=RequestMethod.GET)
	protected String showRegisterAdmin(){
		return "register-admin";
	}
	
	@RequestMapping(value="/admin/addAdmin",method=RequestMethod.POST)
	protected String addAdmin(HttpServletRequest request,ModelMap model){
		String username = request.getParameter("username");
		String rawPassword = request.getParameter("password");
		String password = bcryptEncoder.encode(rawPassword);
		String roleString = request.getParameter("role");
		Role role = roleDAO.getByName(roleString);
		Admin admin = new Admin(username,password,role);
		adminDAO.add(admin);
		model.addAttribute("message","An admin has been added successfully.");
		return "message";
	}
	
	@RequestMapping(value="/admin/manageAdmins",method=RequestMethod.GET)
	protected String showManageAdmins(ModelMap model){
		List<Admin> admins = adminDAO.list();
		model.addAttribute("admins",admins);
		//to be continued
		return "manage-admins";
	}
}
