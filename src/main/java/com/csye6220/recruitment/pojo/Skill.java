package com.csye6220.recruitment.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Skill")
public class Skill {
	@Id
	@Column(name = "Skill_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "skill")
	private String skill;
	
	@ManyToOne
	@JoinColumn(name="Resume_ID", referencedColumnName="Resume_ID")
	private Resume resume;

	public Skill() {
	}

	public Skill(String skill) {
		super();
		this.skill = skill;
	}

	public Skill(Resume resume,String skill) {
		super();
		this.resume = resume;
		this.skill = skill;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
}
