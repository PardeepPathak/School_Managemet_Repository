package com.database.mongo.service;

import java.util.List;
import java.util.Optional;

import com.database.mongo.Model.UserRole;

public interface UserRoleService {
	public List<UserRole> getAllUserRoleData();
	public UserRole addUserRole(UserRole userRole);
	public UserRole updateUserRole(UserRole userRole);
	public void deleteUserRole(String id);
	public Optional<UserRole>  getUserRoleById(String id);
	

}
