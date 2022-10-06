package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.pojo.Student;
import com.student.proxy.StudentProxy;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentProxy proxy;
	
	@GetMapping
	public List<Student> getAllStudentData(){
		LOGGER.info("Inside getAllStudentData() StudentServiceController");
		return proxy.getAllStudentData();
	}
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable String id) {
		LOGGER.info("Inside deleteStudent() StudentServiceController => "+id);
		return proxy.deleteStudent(id);
	}
	
	@PostMapping
	public String addNewStudentData(@RequestBody Student student) {
		LOGGER.info("Inside addNewStudentData() StudentServiceController => "+student);
		return proxy.addNewStudent(student);
	}
	@PutMapping
	public String updateStudentData(@RequestBody Student student) {
		LOGGER.info("Inside updateStudentData() StudentServiceController => "+student);
		return proxy.updateStudentData(student);
	}
	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable String id){
		LOGGER.info("Inside getStudentById() StudentServiceController => "+id);
		return proxy.geStudentById(id);
	}
	
}
