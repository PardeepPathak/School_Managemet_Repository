package com.database.mongo.service;

import java.util.List;
import java.util.Optional;

import com.database.mongo.Model.Student;
import com.database.mongo.pojo.StudentDto;

public interface StudentService {
	public List<Student> getAllStudentData();
	public Student CreatStudentData(Student student);
	public Student updateStudentData(Student student);
	public void deleteStudentData(String id);
	public Optional<Student> getStudentById(String id);
	public boolean existsByEmail(String email);
}
