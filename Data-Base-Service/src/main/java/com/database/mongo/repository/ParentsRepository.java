package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.Parents;

@Repository
public interface ParentsRepository  extends MongoRepository<Parents, String>{

}
