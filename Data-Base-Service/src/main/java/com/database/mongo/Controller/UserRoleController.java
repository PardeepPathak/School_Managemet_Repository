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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongo.Model.UserRole;
import com.database.mongo.serviceImple.UserRoleServiceImple;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {
	@Autowired
	private UserRoleServiceImple userRoleServiceImple;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleController.class);
	@GetMapping
	public List<UserRole> getAllUserRoleData(){
		LOGGER.info("inside GetAllUserRoleData()");
		List<UserRole> role=userRoleServiceImple.getAllUserRoleData();
		return role;
	}
	
	@PostMapping
	public String assigneRoleToUser(@RequestBody UserRole userRole) {
		LOGGER.info("inside assigneRoleToUser()");
		userRoleServiceImple.addUserRole(userRole);
		return "Role Added SuccessFully";
	}
	
	@PutMapping
	public String updateUserRole(@RequestBody UserRole userRole) {
		LOGGER.info("inside updateUserRole()");
		userRoleServiceImple.updateUserRole(userRole);
		return "Role Data ";
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteUserRole(@PathVariable String id) {
		LOGGER.info("inside  deleteUserRole()");
		userRoleServiceImple.deleteUserRole(id);
		return "UserRoleData Deleted SuccessFully";
	}
	
	@GetMapping("/{id}")
	public Optional<UserRole> getUserRoleById(@PathVariable String id){
		LOGGER.info("inside  getUserRoleById()");
		Optional<UserRole> role = userRoleServiceImple.getUserRoleById(id);
		LOGGER.info("inside  getUserRoleById()"+role);
		if(role == null)
			return null;
		else
			return role;
		
	}

}
