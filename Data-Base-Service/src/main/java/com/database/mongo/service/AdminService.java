package com.database.mongo.service;

import java.util.List;
import java.util.Optional;

import com.database.mongo.Model.Admin;

public interface AdminService {
	public List<Admin> getAllAdminData();
	public Admin addNewAdmin(Admin admin);
	public Admin updateAdminData(Admin admin);
	public void  deleteAdminData(String id);
	public Optional<Admin> getAdminById(String id);
}
