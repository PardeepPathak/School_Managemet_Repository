package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.StudentAssignement;
@Repository
public interface StudentAssignementRepo extends MongoRepository<StudentAssignement, String> {

}
