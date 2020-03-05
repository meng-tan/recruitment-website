package com.csye6220.jobboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csye6220.jobboard.service.UserService;

@Controller
public class AjaxController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/check-username", method = RequestMethod.POST)
	@ResponseBody
	public String checkUsername(HttpServletRequest request,@RequestParam("username") String username) {
		System.out.println("got:"+username);
		if(userService.findByUsername(username)!=null) {
			return "Username already exists";
		}
		return "Username is available";
		
	}
}
