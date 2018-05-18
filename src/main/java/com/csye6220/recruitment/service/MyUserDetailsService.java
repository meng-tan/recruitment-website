package com.csye6220.recruitment.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.csye6220.recruitment.dao.UserDAO;
import com.csye6220.recruitment.pojo.User;

public class MyUserDetailsService implements UserDetailsService {

    private UserDAO userDAO;
    
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.get(username);
		System.out.println("myuserdetailservice:"+user);
		org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true,user.getAuthorities());
		return userDetails;
	}

}
