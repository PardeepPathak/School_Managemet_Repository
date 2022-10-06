package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongo.Model.Roles;
import com.database.mongo.repository.RolesRepo;
import com.database.mongo.service.RolesService;

@Service
public class RolesServiceImple implements RolesService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(RolesServiceImple.class);
	
	@Autowired
	private RolesRepo rolesRepo;
	
	
	@Override
	public List<Roles> getAllRoles() {
		LOGGER.info("Inside  getAllRoles() ");
		
		return rolesRepo.findAll();
	}

	@Override
	public Roles addRoles(Roles roles) {
		LOGGER.info("Inside  addRoles() => "+roles);
		
		return rolesRepo.save(roles);
	}

	@Override
	public Optional<Roles> getRoleById(String id) {
		LOGGER.info("Inside  getRoleById() => "+id);
		
		return rolesRepo.findById(id);
	}

	@Override
	public void deleteRole(String id) {
		LOGGER.info("Inside  deleteRole() =>"+id);
		rolesRepo.deleteById(id);
		
	}

}
