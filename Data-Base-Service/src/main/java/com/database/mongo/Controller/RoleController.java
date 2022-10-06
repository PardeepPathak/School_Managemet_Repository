package com.database.mongo.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongo.Model.ERole;
import com.database.mongo.Model.Role;
import com.database.mongo.repository.RoleRepo;

@RestController
@RequestMapping("/role")
public class RoleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleRepo roleRepo;

	@GetMapping("/{name}")
	public Optional<Role> getRole(@PathVariable ERole name) {
		LOGGER.info("Inside getRole()" + name);
		return roleRepo.findByName(name);
	}

}
