package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongo.Controller.UserController;
import com.database.mongo.Model.UserRole;
import com.database.mongo.repository.UserRoleRepo;
import com.database.mongo.service.UserRoleService;

@Service
public class UserRoleServiceImple implements UserRoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleServiceImple.class);

	@Autowired
	private UserRoleRepo userRoleRepo;

	@Override
	public List<UserRole> getAllUserRoleData() {
		LOGGER.info("Inside getAllUserRoleData()");
		return userRoleRepo.findAll();
	}

	@Override
	public UserRole addUserRole(UserRole userRole) {
		LOGGER.info("Inside  addUserRole()" + userRole);
		return userRoleRepo.save(userRole);
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		LOGGER.info("Inside updateUserRole()" + userRole);
		return userRoleRepo.save(userRole);
	}

	@Override
	public void deleteUserRole(String id) {
		LOGGER.info("Inside deleteUserRole()" + id);
		userRoleRepo.deleteById(id);

	}

	@Override
	public Optional<UserRole> getUserRoleById(String id) {
		LOGGER.info("Inside getUserRoleById()" + id);
		return userRoleRepo.findById(id);
	}

}
