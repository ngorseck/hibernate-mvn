package com.sopra.main;

import com.sopra.dao.AppRoleImpl;
import com.sopra.dao.AppUserImpl;
import com.sopra.dao.IAppRole;
import com.sopra.dao.IAppUser;
import com.sopra.dto.AppRoleDto;
import com.sopra.dto.AppUserDto;
import com.sopra.entities.AppRole;
import com.sopra.entities.AppUser;
import com.sopra.service.AppRoleDtoImpl;
import com.sopra.service.IAppRoleDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

	public static void main(String[] args) {


		AppUser appUser = new AppUser();
		appUser.setFullName("Ngor SECK");
		appUser.setPassword("passer1234$#@!");
		appUser.setEmail("seck@isi.sn");
		IAppRole rd = new AppRoleImpl();
		//appUser.setAppRoles(rd.list(new AppRole()));
		IAppUser udao = new AppUserImpl();
		//int result = udao.add(appUser);
		//System.out.println(result);
		//udao.delete(1, appUser);
		//udao.update(user);
		udao.list(appUser).stream()
				.forEach(u->System.out.println("ID : " + u.getId() + " , Email : " + u.getEmail()));

		AppRoleDto appRoleDto = new AppRoleDto();
		appRoleDto.setNom("ADMIN");
		
		
		IAppRoleDto rdao = new AppRoleDtoImpl();
		//int result = rdao.add(appRoleDto);
		//log.info(String.valueOf(result));
		//int result = rdao.add(appRoleDto);
		//System.out.println(result);
		rd.getAdminRolesAndUserV2().stream()
				.forEach(r->System.out.println("Nom : " + r.getFullName() + "Email : " + r.getEmail() + " , Role : " + r.getRoleName()));

		//int idRole = new AppRoleImpl().getByNom("ADMIN").getId();
		//log.info(String.valueOf(idRole));
		// System.out.println(new AppRoleImpl().getByNom("USER").getId());
	}
}
