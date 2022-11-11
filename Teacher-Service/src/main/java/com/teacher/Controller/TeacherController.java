package com.teacher.Controller;

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

import com.teacher.pojo.Teacher;
import com.teacher.proxy.TeacherProxy;
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	private static final Logger LOGGER =LogManager.getLogger(TeacherController.class);
	
	@Autowired
	private TeacherProxy proxy;
	
	@GetMapping
	public List<Teacher> getAllTeacherData(){
		LOGGER.info("Inside getAllTeacherData() TeacherServiceController");
		return proxy.getAllTeacherData();
		
	}
	@PostMapping
	public String addTeacherData(@RequestBody Teacher teacher) {
		LOGGER.info("Inside addTeacherData() TeacherServiceController => "+teacher);
		return proxy.addNewTeacher(teacher);
	}
	@DeleteMapping("/{id}")
	public void deleteTeacherData(@PathVariable String id) {
		LOGGER.info("Inside deleteTeacherData() TeacherServiceController => "+id);
		proxy.deleteTeacher(id);
	}
	
	@PutMapping
	public String updateTeacherData(@RequestBody Teacher teacher) {
		LOGGER.info("Inside updateTeacherData() TeacherServiceController => "+teacher);
		return proxy.updateTeacherData(teacher);
	}
	@GetMapping("/{id}")
	public Optional<Teacher> getTeacherById(@PathVariable String id){
		LOGGER.info("Inside getTeacherById() TeacherServiceController => "+id);
		return proxy.getTeacherById(id);
	}
}
