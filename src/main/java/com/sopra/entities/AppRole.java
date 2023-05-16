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
public class AppRole implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100, nullable = false)
	private String nom;
	@ManyToMany(mappedBy = "appRoles", fetch = FetchType.EAGER)
	private List<AppUser> appUsers = new ArrayList<AppUser>();

	public AppRole(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public AppRole() {
	}

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
	public List<AppUser> getAppUsers() {
		return appUsers;
	}
	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}
	
	
	
}
