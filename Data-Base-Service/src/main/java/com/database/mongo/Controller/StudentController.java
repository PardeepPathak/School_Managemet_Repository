package com.database.mongo.Controller;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongo.Model.Student;
import com.database.mongo.serviceImple.StudentServiceImple;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger LOGGER = LogManager.getLogger(StudentController.class);
	@Autowired
	private StudentServiceImple studentServiceImple;

	@GetMapping
	public List<Student> getAllStudentData() {
		LOGGER.info("Inside getAllStudentData()");
		List<Student> student = studentServiceImple.getAllStudentData();
		return student;
	}

	@PostMapping
	public void addStudentData(@RequestBody Student student) {
		LOGGER.info("Inside addStudentData()" + student);
		studentServiceImple.CreatStudentData(student);
	}

	@PutMapping
	public String updateStudentData(@RequestBody Student student) {
		LOGGER.info("Inside updateStudentData()" + student);
		studentServiceImple.updateStudentData(student);
		return "Student updated SuccessFully";
	}

	@DeleteMapping("/{id}")
	public String deleteStudentData(@PathVariable String id) {
		LOGGER.info("Inside deleteStudentData()" + id);
		studentServiceImple.deleteStudentData(id);
		return "DataDeleted Successfully";
	}

	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable String id) {
		LOGGER.info("Inside getStudentById()" + id);
		Optional<Student> student = studentServiceImple.getStudentById(id);
		LOGGER.info("Inside getStudentById()" + student);
//		if(student == null)
//			return null;
//		else
		return student;
	}

	@GetMapping("/email/{email}")
	public boolean existByEmail(@PathVariable String email) {
		LOGGER.info("Inside existByEmail()" + email);
		return studentServiceImple.existsByEmail(email);
	}

}
