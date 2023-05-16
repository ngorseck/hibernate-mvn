package com.sopra.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AppUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 200, nullable = false)
	private String fullName;
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	@Column(length = 150, nullable = false)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<AppRole> appRoles = new ArrayList<AppRole>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AppRole> getAppRoles() {
		return appRoles;
	}
	public void setAppRoles(List<AppRole> appRoles) {
		this.appRoles = appRoles;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return email;
	}
	
}
