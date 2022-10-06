package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.Subject;
@Repository
public interface SubjectRepo extends MongoRepository<Subject, String>{

}
