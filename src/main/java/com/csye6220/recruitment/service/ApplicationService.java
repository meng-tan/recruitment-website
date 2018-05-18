package com.csye6220.recruitment.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.recruitment.dao.ApplicationDAO;
import com.csye6220.recruitment.pojo.Application;
import com.csye6220.recruitment.pojo.Hr;
import com.csye6220.recruitment.pojo.Post;
import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.pojo.User;

@Service
public class ApplicationService {
	@Autowired
	private ApplicationDAO applicationDAO;
	
	public boolean add(User user,Hr hr,Resume resume,Post post,String coverLetter) {
		if(isDuplicate(resume,post)) {
			return false;
		}else {
			Application application = new Application(user,hr,resume,post,coverLetter,LocalDateTime.now());
			applicationDAO.add(application);
			
			if(user.getApplications()==null) {user.setApplications(new ArrayList<Application>());}
			user.getApplications().add(application);
			
			if(hr.getApplications()==null) {hr.setApplications(new ArrayList<Application>());}
			hr.getApplications().add(application);
			
			if(resume.getApplications()==null) {resume.setApplications(new ArrayList<Application>());}
			resume.getApplications().add(application);
			
			if(post.getApplications()==null) {post.setApplications(new ArrayList<Application>());}
			post.getApplications().add(application);
			
			return true;
		}
	}
	
	public boolean isDuplicate(Resume resume,Post post) {
		Application application = applicationDAO.get(resume,post);
		if (application == null)
			return false;
		else
			return true;
	}
	
	public void processApplication(long applicationId,String status,String message) {
		Application application = applicationDAO.getById(applicationId);
		application.setStatus(status);
		application.setMessage(message);
		application.setProcessTime(LocalDateTime.now());
		applicationDAO.update(application);
	}
}
