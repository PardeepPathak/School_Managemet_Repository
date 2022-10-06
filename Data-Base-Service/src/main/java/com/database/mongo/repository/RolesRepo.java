package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.Roles;

@Repository
public interface RolesRepo extends MongoRepository<Roles, String> {

}
