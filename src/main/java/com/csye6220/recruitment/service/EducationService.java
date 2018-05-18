package com.csye6220.recruitment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.recruitment.dao.EducationDAO;
import com.csye6220.recruitment.pojo.Education;
import com.csye6220.recruitment.pojo.Resume;
@Service
public class EducationService {
	@Autowired
	private EducationDAO eduDAO;
	
	public void add(Resume resume,String[] eduFrom,String[] eduTo,String[] university,String[] degree,String[] major) {
		for(int i=0;i<eduFrom.length;i++) {
			Education edu = new Education(resume,eduFrom[i],eduTo[i],university[i],degree[i],major[i]);
			eduDAO.add(edu);

			if(resume.getEducationBackgrounds()==null) {resume.setEducationBackgrounds(new ArrayList<Education>());}
			resume.getEducationBackgrounds().add(edu);
		}
	}
	
	public List<Education> list(Resume resume){
		return eduDAO.list(resume);
	}
}
