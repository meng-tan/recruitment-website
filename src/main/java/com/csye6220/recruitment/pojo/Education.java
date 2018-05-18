package com.csye6220.recruitment.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Education")
public class Education {
	@Id
	@Column(name = "Edu_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="eduFrom",columnDefinition="varchar(225) DEFAULT NULL")
	private String eduFrom;
	
	@Column(name="eduTo",columnDefinition="varchar(225) DEFAULT NULL")
	private String eduTo;
	
	@Column(name="university")
	private String university;
	
	@Column(name="degree")
	private String degree;
	
	@Column(name="major")
	private String major;
	
	@ManyToOne
	@JoinColumn(name="Resume_ID", referencedColumnName="Resume_ID")
	private Resume resume;

	public Education() {
	}

	public Education(String eduFrom, String eduTo, String university, String degree, String major) {
		super();
		this.eduFrom = eduFrom;
		this.eduTo = eduTo;
		this.university = university;
		this.degree = degree;
		this.major = major;
	}

	public Education(Resume resume,String eduFrom, String eduTo, String university, String degree, String major) {
		super();
		this.eduFrom = eduFrom;
		this.eduTo = eduTo;
		this.university = university;
		this.degree = degree;
		this.major = major;
		this.resume = resume;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getEduFrom() {
		return eduFrom;
	}

	public void setEduFrom(String eduFrom) {
		this.eduFrom = eduFrom;
	}

	public String getEduTo() {
		return eduTo;
	}

	public void setEduTo(String eduTo) {
		this.eduTo = eduTo;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
}
