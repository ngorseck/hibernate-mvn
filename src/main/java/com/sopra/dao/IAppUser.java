package com.sopra.dao;


import com.sopra.entities.AppUser;

public interface IAppUser extends Repository<AppUser> {

	public AppUser getByEmail(String email);
}
