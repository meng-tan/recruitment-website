package com.csye6220.recruitment.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.recruitment.dao.ResumeDAO;
import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.pojo.User;
@Service
public class ResumeService {
	@Autowired
	private ResumeDAO resumeDAO;

	public void add(User user,Resume resume) {
		resume.setUser(user);
		resumeDAO.add(resume);
		if(user.getResumes()==null) {user.setResumes(new ArrayList<Resume>());}
		user.getResumes().add(resume);
	}
}
