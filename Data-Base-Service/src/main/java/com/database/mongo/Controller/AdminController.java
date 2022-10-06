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

import com.database.mongo.Model.Admin;
import com.database.mongo.serviceImple.AdminServiceImple;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminServiceImple adminServicImple;

	@GetMapping
	public List<Admin> getAllAdminData() {
		LOGGER.info("Inside getAllAdminData()");
		List<Admin> admin = adminServicImple.getAllAdminData();
		return admin;
	}

	@PostMapping
	public String addNewAdminData(@RequestBody Admin admin) {
		LOGGER.info("Inside addNewAdminData()" + admin);
		adminServicImple.addNewAdmin(admin);
		return "Admin Data Added SuccessFully";
	}

	@PutMapping
	public String updateAdminData(@RequestBody Admin admin) {
		LOGGER.info("Inside updateAdminData()" + admin);
		adminServicImple.updateAdminData(admin);
		return " Admin Data Updated SuccessFully ";
	}

	@DeleteMapping("/{id}")
	public String deleteAdminData(@PathVariable String id) {
		LOGGER.info("Inside deleteAdminData()" + id);
		adminServicImple.deleteAdminData(id);
		return "Data Deleted SuccessFully";
	}

	@GetMapping("/{id}")
	public Optional<Admin> getAdminDataById(@PathVariable String id) {
		LOGGER.info("Inside getAdminDataById()" + id);
		Optional<Admin> admin = adminServicImple.getAdminById(id);
		LOGGER.info("Inside getAdminDataById()" + id);
		if (admin == null)
			return null;
		else
			return admin;
	}
}
