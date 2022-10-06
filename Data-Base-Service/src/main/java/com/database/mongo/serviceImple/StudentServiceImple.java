package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongo.Model.Student;
import com.database.mongo.repository.StudentRepo;
import com.database.mongo.service.StudentService;

@Service
public class StudentServiceImple implements StudentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImple.class);
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudentData() {
		LOGGER.info("Inside getAllStudentData()");

		return studentRepo.findAll();
	}

	@Override
	public Student CreatStudentData(Student student) {
		LOGGER.info("Inside CreatStudentData()" + student);

		return studentRepo.save(student);
	}

	@Override
	public Student updateStudentData(Student student) {
		LOGGER.info("Inside updateStudentData()" + student);

		return studentRepo.save(student);
	}

	@Override
	public void deleteStudentData(String id) {
		LOGGER.info("Inside deleteStudentData()" + id);
		studentRepo.deleteById(id);
	}

	@Override
	public Optional<Student> getStudentById(String id) {
		LOGGER.info("Inside getStudentById()" + id);
		return studentRepo.findById(id);
	}

	@Override
	public boolean existsByEmail(String email) {
		LOGGER.info("Inside existsByEmail()" + email);
		return studentRepo.existsByEmail(email);
	}

}
