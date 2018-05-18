package com.csye6220.recruitment.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Hr")
@PrimaryKeyJoinColumn
public class Hr extends User {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hr")
	private List<Post> posts;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hr")
	private List<Application> applications;

	public Hr() {
		super();
	}
	
	public Hr(String username, String password) {
		super(username,password);
	}

	public Hr(String username, String password, Role role) {
		super(username,password,role);
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}
