package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongo.Model.Admin;
import com.database.mongo.repository.AdminRepo;
import com.database.mongo.service.AdminService;
@Service
public class AdminServiceImple implements AdminService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AdminServiceImple.class);
	
	@Autowired
	private AdminRepo adminRepo;
	
	
	@Override
	public List<Admin> getAllAdminData() {
		LOGGER.info("Inside  getAllAdminData() ");
		return adminRepo.findAll();
	}

	@Override
	public Admin addNewAdmin(Admin admin) {
		LOGGER.info("Inside  addNewAdmin() => "+admin);
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdminData(Admin admin) {
		LOGGER.info("Inside  updateAdminData() => "+admin);
		return adminRepo.save(admin);
	}

	@Override
	public void deleteAdminData(String id) {
		LOGGER.info("Inside  deleteAdminData() => "+id);
		adminRepo.deleteById(id);
		
	}

	@Override
	public Optional<Admin> getAdminById(String id) {
		LOGGER.info("Inside  getAdminById() => "+id);
		return adminRepo.findById(id);
	}

}
