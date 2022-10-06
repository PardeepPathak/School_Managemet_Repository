package com.database.mongo.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongo.Model.Roles;
import com.database.mongo.serviceImple.RolesServiceImple;

@RestController
@RequestMapping("/roles")
public class RolesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RolesController.class);

	@Autowired
	private RolesServiceImple rolesServiceImple;

	@GetMapping
	public List<Roles> getAllRoleData() {
		LOGGER.info("Inside getAllRoleData()");
		List<Roles> roles = rolesServiceImple.getAllRoles();
		return roles;
	}

	@PostMapping
	public String addNewRole(@RequestBody Roles roles) {
		LOGGER.info("Inside addNewRole()" + roles);
		rolesServiceImple.addRoles(roles);
		return "Roles  Data Added SuccessFully";
	}

	@DeleteMapping("/{id}")
	public String deleteRoleData(@PathVariable String id) {
		LOGGER.info("Inside deleteRoleData()" + id);
		rolesServiceImple.deleteRole(id);
		return "Roles Data Deleted Succfully";
	}

	@GetMapping("/{id}")
	public Optional<Roles> getRolesDataById(@PathVariable String id) {
		LOGGER.info("Inside getRolesDataById()" + id);
		Optional<Roles> roles = rolesServiceImple.getRoleById(id);
		LOGGER.info("Inside getRolesDataById()" + id);
		if (roles == null)
			return null;
		else
			return roles;
	}

}
