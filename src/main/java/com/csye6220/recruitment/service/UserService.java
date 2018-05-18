package com.csye6220.recruitment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.recruitment.dao.AdminDAO;
import com.csye6220.recruitment.dao.HrDAO;
import com.csye6220.recruitment.dao.UserDAO;
import com.csye6220.recruitment.pojo.Admin;
import com.csye6220.recruitment.pojo.Hr;
import com.csye6220.recruitment.pojo.User;
@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private HrDAO hrDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
	public boolean isDuplicate(String username) {
		User user = userDAO.get(username);
		Hr hr = hrDAO.get(username);
		Admin admin = adminDAO.get(username);
		if (user == null && hr == null && admin == null) {
			return false;
		}else {
			return true;
		}
	}
}
