package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.TeacherAssignementUpload;
@Repository
public interface TeacherAssignementRepo extends MongoRepository<TeacherAssignementUpload, String> {

}
