package com.csye6220.jobboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.jobboard.dao.UserDAO;
import com.csye6220.jobboard.model.User;

@Service
public class UserService {
	@Autowired
    private UserDAO userDAO;
	
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
		
	}
}
