package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.Admin;

@Repository
public interface AdminRepo extends MongoRepository<Admin, String> {

}
