package com.csye6220.recruitment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.recruitment.dao.ExperienceDAO;
import com.csye6220.recruitment.pojo.Experience;
import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.pojo.Skill;
@Service
public class ExperienceService {
	@Autowired
	private ExperienceDAO expDAO;
	
	public void add(Resume resume,String[] expFrom, String[] expTo, String[] company, String[] title, String[] responsibility) {
		for(int i=0;i<expFrom.length;i++) {
			Experience exp = new Experience(resume,expFrom[i],expTo[i],company[i],title[i],responsibility[i]);
			expDAO.add(exp);

			if(resume.getExperiences()==null) {resume.setExperiences(new ArrayList<Experience>());}
			resume.getExperiences().add(exp);
		}
	}
	
	public List<Experience> list(Resume resume){
		return expDAO.list(resume);
	}
}
