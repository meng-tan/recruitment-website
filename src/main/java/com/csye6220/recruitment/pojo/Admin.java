package com.csye6220.recruitment.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
@PrimaryKeyJoinColumn
public class Admin extends User {

	public Admin() {
		super();
	}
	
	public Admin(String username, String password) {
		super(username,password);
	}

	public Admin(String username, String password, Role role) {
		super(username,password,role);
	}
}
