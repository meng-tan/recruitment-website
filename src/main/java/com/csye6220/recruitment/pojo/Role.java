package com.csye6220.recruitment.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="Role")
public class Role {

	@Id
	@Column(name = "Role_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private List<User> users;

	public Role() {
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public Role(long id, String role, List<User> users) {
		super();
		this.id = id;
		this.role = role;
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
