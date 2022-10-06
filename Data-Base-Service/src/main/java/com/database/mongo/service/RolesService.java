package com.database.mongo.service;

import java.util.List;
import java.util.Optional;

import com.database.mongo.Model.Roles;

public interface RolesService {
	public List<Roles> getAllRoles();
	public Roles addRoles(Roles roles);
	public Optional<Roles> getRoleById(String id);
	public void deleteRole(String id);
	
}
