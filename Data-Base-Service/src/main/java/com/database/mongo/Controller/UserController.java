package com.database.mongo.Controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongo.Model.User;
import com.database.mongo.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

//   Logger logger= LogManager.getLogger(UserController.class);

	@Autowired
	private UserRepo userRepo;

	@PostMapping
	public void saveUserData(@RequestBody User user) {
		LOGGER.info("inside  saveUserData()"+user);
		userRepo.save(user);
	}

	@GetMapping
	public List<User> getAllUsers() {
		LOGGER.info("inside  getAllUsers()");
		return userRepo.findAll();
	}

	@GetMapping("/{email}")
	public User findByUsername(@PathVariable String email) {
		LOGGER.info("inside findByUsername()" + email);
		User user = userRepo.findByEmail(email);
		LOGGER.info("inside findByUsername()" +user);
//		if(user.isEmpty())
//			throw new UserNotFoundException();
		return user;
	}

	@GetMapping("/email/{email}")
	public boolean existByEmail(@PathVariable String email) {
		LOGGER.info("inside existByEmail()" + email);
		return userRepo.existsByEmail(email);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id) {
		LOGGER.info("inside deleteUser()"+id);
		userRepo.deleteById(id);
	}
	@PutMapping()
	public String updateUserData(@RequestBody User user) {
		userRepo.save(user);
		return "User updated SuccessFuly";
		
	}

}
