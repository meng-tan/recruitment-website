package com.csye6220.recruitment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.recruitment.dao.SkillDAO;
import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.pojo.Skill;
@Service
public class SkillService {
	@Autowired
	private SkillDAO skillDAO;
	
	public void add(Resume resume, String[] skill) {
		
		for(int i=0;i<skill.length;i++) {
			Skill s = new Skill(resume, skill[i]);
			skillDAO.add(s);
			
			if(resume.getSkills()==null) {resume.setSkills(new ArrayList<Skill>());}
			resume.getSkills().add(s);
		}
	}
	
	public List<Skill> list(Resume resume){
		return skillDAO.list(resume);
	}
}
