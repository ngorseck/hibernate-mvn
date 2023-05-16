package com.sopra.dto;

import java.util.ArrayList;
import java.util.List;


import com.sopra.entities.AppRole;

public class AppUserDto {

	private int id;
	private String email;
	private String password;
	private List<String> appRoles = new ArrayList<String>();
	
	
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
	public List<String> getAppRoles() {
		return appRoles;
	}
	public void setAppRoles(List<String> appRoles) {
		this.appRoles = appRoles;
	}
}
