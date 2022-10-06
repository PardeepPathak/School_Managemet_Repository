package com.database.mongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.database.mongo.Model.User;

public interface UserRepo extends MongoRepository<User, String>{
	User findByEmail(String email);
	 public boolean existsByEmail(String email);
	
}
