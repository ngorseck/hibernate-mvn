package com.sopra.dao;

import com.sopra.entities.AppRole;

import java.util.List;


public interface IAppRole extends Repository<AppRole> {

	public AppRole getByNom(String email);
	public List<AppRole> getUsersRoles();

	public List<AppRole> getAdminRoles();
	public List<UserRolesTuple> getAdminRolesAndUserV2();
}
