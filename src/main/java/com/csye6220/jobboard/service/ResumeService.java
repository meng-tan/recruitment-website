package com.csye6220.jobboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.jobboard.dao.ResumeDAO;
import com.csye6220.jobboard.model.Applicant;
import com.csye6220.jobboard.model.Resume;

@Service
public class ResumeService {
	@Autowired
    private ResumeDAO resumeDAO;
	
	public void create(Resume resume) {
		resumeDAO.create(resume);
	}

	public List<Resume> list() {
		return resumeDAO.list();
	}
	
	public Resume findById(int id) {
		return resumeDAO.findById(id);
	}

	public List<Resume> findByFilter(String[] objectives, String experience, String[] degrees, String target) {
		return resumeDAO.findByFilter(objectives,experience,degrees,target);
	}

	public List<Resume> findByApplicant(Applicant applicant) {
		return resumeDAO.findByApplicant(applicant);
	}
}
