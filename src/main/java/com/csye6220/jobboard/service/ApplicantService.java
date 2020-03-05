package com.csye6220.jobboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.csye6220.jobboard.dao.ApplicantDAO;
import com.csye6220.jobboard.dao.RoleDAO;
import com.csye6220.jobboard.model.Applicant;
import com.csye6220.jobboard.model.Role;

@Service
public class ApplicantService {
	
	@Autowired
    private ApplicantDAO applicantDAO;
	
	@Autowired
    private RoleDAO roleDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	public void create(String username, String password, String roleName) {
		Role role = roleDAO.findByRoleName(roleName);
		if(role==null) {
			Role applicantRole = new Role();
			applicantRole.setId(1);
			applicantRole.setRole("applicant");
			roleDAO.create(applicantRole);
		}
		Applicant applicant = new Applicant();
		applicant.setUsername(username);
		applicant.setPassword(bcryptEncoder.encode(password));
		applicant.setRole(roleDAO.findByRoleName(roleName));
		applicantDAO.create(applicant);	
	}
	
	public Applicant findByUsername(String username) {
		return applicantDAO.findByUsername(username);
		
	}

}
