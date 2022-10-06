package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.Classes;
@Repository
public interface ClassesRepo extends MongoRepository<Classes,String > {
	

}
