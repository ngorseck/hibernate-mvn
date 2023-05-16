package com.sopra.dao;

import java.util.ArrayList;
import java.util.List;

import com.sopra.dto.AppRoleDto;
import com.sopra.entities.AppRole;
import com.sopra.entities.AppUser;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;

public class AppRoleImpl extends RepositoryImpl<AppRole> implements IAppRole {

	@Override
	public AppRole getByNom(String nom) {
		
		return (AppRole) session.createQuery(
							"FROM AppRole role WHERE role.nom = :role_nom")
							.setParameter("role_nom", nom)
							.uniqueResult();
	}

	/**
	 * https://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html#criteria
	 * @return
	 */
	@Override
	public List<AppRole> getUsersRoles() {
		Query query = session.createQuery(
						"select appRole " +
								"from AppRole appRole " +
								"where appRole.nom like ?1" )
				.setParameter( 1, "%USER%" );

		return query.getResultList();
	}

	/**
	 * https://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html#criteria
	 * @return
	 */
	@Override
	public List<AppRole> getAdminRoles() {
		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<AppRole> criteria = builder.createQuery( AppRole.class );
		Root<AppRole> root = criteria.from( AppRole.class );

		Path<Integer> idPath = root.get( "id" );
		Path<String> namePath = root.get( "nom");

		criteria.select( builder.construct( AppRole.class, idPath, namePath ) );

		criteria.where( builder.like( namePath, "%ADMIN%" ) );

		List<AppRole> appRoles = session.createQuery( criteria ).getResultList();
		return appRoles;
	}

	/**
	 * @return
	 */
	@Override
	public List<UserRolesTuple> getAdminRolesAndUserV2() {
		/**
		 * Creation du builder
		 */
		CriteriaBuilder builder = session.getCriteriaBuilder();
		/**
		 * Initialisation du criteria
		 * ici on utilise un objet de tupe Tuple comme resultat
		 * car nous aurons des objets
		 */
		CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
		/**
		 * Appel des Entities
		 */
		Root<AppRole> roleRoot = criteria.from(AppRole.class);
		Root<AppUser> userRoot = criteria.from(AppUser.class);

		/**
		 * Cette projection retourne deux objets
		 * respectant la close where et dans l´ordre (appRole puis appUser)
		 */
		criteria.multiselect(roleRoot, userRoot);
		/**
		 * Predicate pour les close sql
		 */
		Predicate rolesRestriction = builder.and(
				builder.equal(roleRoot.get("nom"), "ADMIN")//,
				//builder.isNotEmpty(roleRoot.get("nom"))
		);
		Predicate userRestriction = builder.and(
				builder.like(userRoot.get("fullName"), "%SECK%"),
				builder.like(userRoot.get("password"), "%pas%")
		);
		/**
		 * Close sql
		 * Utilisation des predicates dans les closes where
		 */
		criteria.where(builder.and(rolesRestriction, userRestriction));
		/**
		 * recuperation des tuples
		 */
		List<Tuple> tuples = session.createQuery(criteria).getResultList();
		List<UserRolesTuple> userRolesTuples = new ArrayList<>();
		for (Tuple tuple : tuples) {
			UserRolesTuple userRolesTuple = new UserRolesTuple(
					((AppUser) tuple.get(1)).getFullName(),
					((AppUser) tuple.get(1)).getEmail(),
					((AppRole) tuple.get(0)).getNom()
			);
			userRolesTuples.add(userRolesTuple);
		}
		return userRolesTuples;
	}


	public AppRole appRoleDtoToAppRoleEntity (AppRoleDto appRoleDto) {
		AppRole appRole = new AppRole();
		appRole.setId(appRoleDto.getId());
		appRole.setNom(appRoleDto.getNom());
		if (appRoleDto.getAppUsers() != null) {
			List<AppUser> appUsers = new ArrayList<AppUser>();
			appRoleDto.getAppUsers().forEach(email->{
				AppUser appUser = new AppUserImpl().getByEmail(email);
				appUsers.add(appUser);
			});
			appRole.setAppUsers(appUsers);
		}
		
		return appRole;
	}
	
	public AppRoleDto appRoleEntityToAppRoleDto (AppRole appRole) {
		AppRoleDto appRoleDto = new AppRoleDto();
		appRoleDto.setId(appRole.getId());
		appRoleDto.setNom(appRole.getNom());
		if (appRole.getAppUsers() != null) {
			List<String> emailUsers = new ArrayList<String>();
			appRole.getAppUsers().forEach(user->{
				emailUsers.add(user.getEmail());
			});
			appRoleDto.setAppUsers(emailUsers);
		}
		return appRoleDto;
	}
}
