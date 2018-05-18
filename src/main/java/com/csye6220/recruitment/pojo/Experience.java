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
@Table(name="Experience")
public class Experience {
	@Id
	@Column(name = "Exp_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="expFrom",columnDefinition="varchar(225) DEFAULT NULL")
	private String expFrom;
	
	@Column(name="expTo",columnDefinition="varchar(225) DEFAULT NULL")
	private String expTo;
	
	@Column(name="company")
	private String company;
	
	@Column(name="title")
	private String title;
	
	@Column(name="responsibility")
	private String responsibility;
	
	@ManyToOne
	@JoinColumn(name="Resume_ID", referencedColumnName="Resume_ID")
	private Resume resume;

	public Experience() {
	}

	public Experience(String expFrom, String expTo, String company, String title, String responsibility) {
		super();
		this.expFrom = expFrom;
		this.expTo = expTo;
		this.company = company;
		this.title = title;
		this.responsibility = responsibility;
	}
	
	

	public Experience(Resume resume,String expFrom, String expTo, String company, String title, String responsibility) {
		super();
		this.expFrom = expFrom;
		this.expTo = expTo;
		this.company = company;
		this.title = title;
		this.responsibility = responsibility;
		this.resume = resume;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getExpFrom() {
		return expFrom;
	}

	public void setExpFrom(String expFrom) {
		this.expFrom = expFrom;
	}

	public String getExpTo() {
		return expTo;
	}

	public void setExpTo(String expTo) {
		this.expTo = expTo;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
}
