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
@Table(name="Resume")
public class Resume {
	@Id
	@Column(name = "Resume_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="User_ID", referencedColumnName="User_ID")
	private User user;
	
	@Column(name="resumeTitle")
	private String resumeTitle;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@Column(name="email")
	private String email;

	@Column(name="tel")
	private String tel;

	@Column(name="objective")
	private String objective;
	
	@OneToMany(cascade= {CascadeType.ALL},mappedBy="resume")
	private List<Education> educationBackgrounds;

	@OneToMany(cascade= {CascadeType.ALL},mappedBy="resume")
	private List<Experience> experiences;
	
	@OneToMany(cascade= {CascadeType.ALL},mappedBy="resume")
	private List<Skill> skills;
	
	@OneToMany(cascade= {CascadeType.ALL},mappedBy="resume")
	private List<Application> applications;

	public Resume() {
	}

	public Resume(String resumeTitle, String firstName, String lastName, String email, String tel, String objective) {
		super();
		this.resumeTitle = resumeTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tel = tel;
		this.objective = objective;
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

	public void setUser(User user) {
		this.user = user;
	}

	public String getResumeTitle() {
		return resumeTitle;
	}

	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public List<Education> getEducationBackgrounds() {
		return educationBackgrounds;
	}

	public void setEducationBackgrounds(List<Education> educationBackgrounds) {
		this.educationBackgrounds = educationBackgrounds;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
}
