package com.database.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.Teacher;
@Repository
public interface TeacherRepo  extends MongoRepository<Teacher, String>{

}
