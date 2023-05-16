package com.sopra.dto;

import java.util.ArrayList;
import java.util.List;

import com.sopra.dao.AppRoleImpl;
import com.sopra.dao.AppUserImpl;
import com.sopra.entities.AppRole;
import com.sopra.entities.AppUser;


public class AppRoleDto {

	private int id;
	private String nom;
	private List<String> appUsers = new ArrayList<String>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<String> getAppUsers() {
		return appUsers;
	}
	public void setAppUsers(List<String> appUsers) {
		this.appUsers = appUsers;
	}
	
	
}
