package com.csye6220.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csye6220.recruitment.service.UserService;

@Controller
public class AjaxController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/**/checkUsername", method = RequestMethod.POST)
	@ResponseBody
	public String checkUsername(@RequestBody String jsonString) {
		int index = jsonString.indexOf("=");
		String username = jsonString.substring(index+1);
		if(userService.isDuplicate(username)) {
			return "Username already been used, please choose another one.";
		}else {
			return "available";
		}
	}
	
}
