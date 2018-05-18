package com.csye6220.recruitment.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Application")
public class Application {
	@Id
	@Column(name = "Application_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="User_ID", referencedColumnName="User_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="Hr_ID", referencedColumnName="User_ID")
	private Hr hr;
	
	@ManyToOne
	@JoinColumn(name="Resume_ID", referencedColumnName="Resume_ID")
	private Resume resume;
	
	@ManyToOne
	@JoinColumn(name="Post_ID", referencedColumnName="Post_ID")
	private Post post;
	
	@Column(name="status")
	private String status="Pending";
	
	@Column(name="coverLetter")
	private String coverLetter;
	
	@Column(name="message")
	private String message;
	
	@Column(name="applyTime")
	private LocalDateTime applyTime;
	
	@Column(name="processTime")
	private LocalDateTime processTime;

	public Application() {
	}

	public Application(Resume resume, Post post) {
		super();
		this.resume = resume;
		this.post = post;
	}

	public Application(User user, Resume resume, Post post) {
		super();
		this.user = user;
		this.resume = resume;
		this.post = post;
	}

	public Application(User user, Resume resume, Post post, String coverLetter,
			LocalDateTime applyTime) {
		super();
		this.user = user;
		this.resume = resume;
		this.post = post;
		this.coverLetter = coverLetter;
		this.applyTime = applyTime;
	}

	public Application(User user, Hr hr, Resume resume, Post post, String coverLetter, LocalDateTime applyTime) {
		super();
		this.user = user;
		this.hr = hr;
		this.resume = resume;
		this.post = post;
		this.coverLetter = coverLetter;
		this.applyTime = applyTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public Hr getHr() {
		return hr;
	}

	public void setHr(Hr hr) {
		this.hr = hr;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(LocalDateTime applyTime) {
		this.applyTime = applyTime;
	}

	public LocalDateTime getProcessTime() {
		return processTime;
	}

	public void setProcessTime(LocalDateTime processTime) {
		this.processTime = processTime;
	}
	
	
}
