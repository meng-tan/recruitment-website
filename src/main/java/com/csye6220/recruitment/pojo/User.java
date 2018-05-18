package com.csye6220.recruitment.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name="User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {
	@Id
	@Column(name = "User_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;

	@Column(name = "username")
	@NotNull
	protected String username;

	@Column(name = "password")
	@NotNull
	protected String password;

	@ManyToOne(optional = false)
	@JoinColumn(name="Role_ID", referencedColumnName="Role_ID")
	protected Role role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Resume> resumes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Application> applications;
	
	public User() {
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(getRole().getRole()));
		System.out.println("authorities :"+authorities.toString());
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
