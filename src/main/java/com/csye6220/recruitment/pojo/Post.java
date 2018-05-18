package com.csye6220.recruitment.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Post")
public class Post {
	@Id
	@Column(name = "Post_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "postTitle")
	private String postTitle;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "numNeeded")
	private int numNeeded;
	
	@Column(name = "requirement")
	private String requirement;
	
	@Column(name = "responsibility")
	private String responsibility;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "dateBefore")
	private String dateBefore;
	
	@Column(name = "picPath")
	private String picPath;
	
	@ManyToOne
	@JoinColumn(name="User_ID", referencedColumnName="User_ID")
	private Hr hr;
	
	@OneToMany(cascade= {CascadeType.ALL},mappedBy="post")
	private List<Application> applications;

	public Post() {
	}

	public Post(String postTitle, String company, String address, String position, String type, int numNeeded,
			String requirement, String responsibility, String salary, String contact, String dateBefore) {
		super();
		this.postTitle = postTitle;
		this.company = company;
		this.address = address;
		this.position = position;
		this.type = type;
		this.numNeeded = numNeeded;
		this.requirement = requirement;
		this.responsibility = responsibility;
		this.salary = salary;
		this.contact = contact;
		this.dateBefore = dateBefore;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDateBefore() {
		return dateBefore;
	}

	public void setDateBefore(String dateBefore) {
		this.dateBefore = dateBefore;
	}

	public Hr getHr() {
		return hr;
	}

	public void setHr(Hr hr) {
		this.hr = hr;
	}

	public int getNumNeeded() {
		return numNeeded;
	}

	public void setNumNeeded(int numNeeded) {
		this.numNeeded = numNeeded;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
}