package com.csye6220.jobboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.csye6220.jobboard.dao.RecruiterDAO;
import com.csye6220.jobboard.dao.RoleDAO;
import com.csye6220.jobboard.model.Applicant;
import com.csye6220.jobboard.model.Recruiter;
import com.csye6220.jobboard.model.Role;
@Service
public class RecruiterService {
	
	@Autowired
    private RecruiterDAO recruiterDAO;
	
	@Autowired
    private RoleDAO roleDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	public void create(String username, String password, String roleName) {
		Role role = roleDAO.findByRoleName(roleName);
		if(role==null) {
			Role recruiterRole = new Role();
			recruiterRole.setId(2);
			recruiterRole.setRole("recruiter");
			roleDAO.create(recruiterRole);
		}
		
		Recruiter recruiter = new Recruiter();
		recruiter.setUsername(username);
		recruiter.setPassword(bcryptEncoder.encode(password));
		recruiter.setRole(roleDAO.findByRoleName(roleName));
		recruiterDAO.create(recruiter);	
	} 
	public Recruiter findByUsername(String username) {
		return recruiterDAO.findByUsername(username);
		
	}
}
