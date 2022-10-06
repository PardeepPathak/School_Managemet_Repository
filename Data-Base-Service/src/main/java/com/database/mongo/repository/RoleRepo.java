package com.database.mongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.database.mongo.Model.ERole;
import com.database.mongo.Model.Role;

public interface RoleRepo extends MongoRepository<Role, String>{
	public Optional<Role> findByName(ERole name);
}
