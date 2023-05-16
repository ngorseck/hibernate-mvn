package com.sopra.service;

import java.util.ArrayList;
import java.util.List;

import com.sopra.dao.AppRoleImpl;
import com.sopra.dao.IAppRole;
import com.sopra.dto.AppRoleDto;
import com.sopra.entities.AppRole;

public class AppRoleDtoImpl implements IAppRoleDto {

	private AppRoleImpl appRoledao = new AppRoleImpl();
	@Override
	public int add(AppRoleDto appRoleDto) {
		
		return appRoledao.add(appRoledao.appRoleDtoToAppRoleEntity(appRoleDto));
	}

	@Override
	public int delete(int id) {
		
		return appRoledao.delete(id, new AppRole());
	}

	@Override
	public int update(AppRoleDto appRoleDto) {
		
		return appRoledao.update(appRoledao.appRoleDtoToAppRoleEntity(appRoleDto));
	}

	@Override
	public List<AppRoleDto> list() {
		List<AppRoleDto> appRoleDtos = new ArrayList<AppRoleDto>();
		appRoledao.list(new AppRole()).forEach(appRole -> {
			
			appRoleDtos.add(appRoledao.appRoleEntityToAppRoleDto(appRole));
		});
		return appRoleDtos;
	}

	@Override
	public AppRoleDto get(int id) {
		
		return appRoledao.appRoleEntityToAppRoleDto(appRoledao.get(id, new AppRole()));
	}

	/**
	 * @return
	 */
	@Override
	public List<AppRoleDto> getUsersRoles() {
		return null;
	}

	/**
	 * @return
	 */
	@Override
	public List<AppRoleDto> getAdminRoles() {
		List<AppRoleDto> appRoleDtos = new ArrayList<AppRoleDto>();
		appRoledao.getAdminRoles().forEach(appRole -> {

			appRoleDtos.add(appRoledao.appRoleEntityToAppRoleDto(appRole));
		});
		return appRoleDtos;
	}

}
