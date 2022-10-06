package com.database.mongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongo.Model.Student;
@Repository
public interface StudentRepo extends MongoRepository<Student,String>{
	public boolean existsByEmail(String email);
//	public Optional<Student> getStudentById(String studentId);
}
