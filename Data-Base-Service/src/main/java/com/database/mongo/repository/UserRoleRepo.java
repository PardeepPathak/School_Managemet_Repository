package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.UserRole;

@Repository
public interface UserRoleRepo extends MongoRepository<UserRole, String> {

}
