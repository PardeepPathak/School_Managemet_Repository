package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.School;
@Repository
public interface SchoolRepo extends MongoRepository<School, String> {

}
