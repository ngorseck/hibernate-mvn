package com.sopra.service;

import com.sopra.dto.AppRoleDto;
import com.sopra.entities.AppRole;

import java.util.List;


public interface IAppRoleDto {

	public int add(AppRoleDto appRoleDto);
	public int delete(int id);
	public int update(AppRoleDto appRoleDto);
	public List<AppRoleDto> list();
	public AppRoleDto get(int id);

	public List<AppRoleDto> getUsersRoles();

	public List<AppRoleDto> getAdminRoles();
}
