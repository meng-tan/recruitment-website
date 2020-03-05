package com.csye6220.jobboard.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.csye6220.jobboard.model.Resume;
import com.csye6220.jobboard.model.Application;

@Entity
@Table(name = "applicant")
@PrimaryKeyJoinColumn(name = "applicant_id", referencedColumnName = "user_id")
public class Applicant extends User {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "applicant")
	private List<Resume> resumes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "applicant")
	private List<Application> applications;
	

	public Applicant() {
		super();
	}


	public List<Resume> getResumes() {
		return resumes;
	}


	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}


	public List<Application> getApplications() {
		return applications;
	}


	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	
}
