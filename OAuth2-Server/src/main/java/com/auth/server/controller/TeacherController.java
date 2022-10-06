package com.auth.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.server.pojo.Teacher;
import com.auth.server.pojo.User;
import com.auth.server.proxy.TeacherProxy;
import com.auth.server.proxy.UserProxy;
import com.auth.server.utils.ResourceNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/teacher")
public class TeacherController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

	@Autowired
	private TeacherProxy teacherProxy;
	@Autowired
	private UserProxy userProxy;

	@GetMapping
//	@PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
	public List<Teacher> getAllTeacherData() {
		LOGGER.info("Inside getAllTeacherData() AuthApiTeacherController => ");
		return teacherProxy.getAllTeacher();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable String id) {
		LOGGER.info("Inside getTeacherById() AuthApiTeacherController => " + id);
		Teacher teacher = teacherProxy.getTeacherById(id).orElseThrow(() -> new ResourceNotFoundException());
		return ResponseEntity.ok(teacher);
	}

	@PutMapping("/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateTeacherData(@PathVariable(value = "id") String teacherId,
			@RequestBody Teacher teacherDetails) {
		LOGGER.info(
				"Inside getTeacherById() AuthApiTeacherController => " + teacherId + " Details => " + teacherDetails);
		Teacher teacher = teacherProxy.getTeacherById(teacherId).orElseThrow(() -> new ResourceNotFoundException());
		teacher.setAddress(teacherDetails.getAddress());
		teacher.setDob(teacherDetails.getDob());
		teacher.setFirstName(teacherDetails.getFirstName());
		teacher.setLastName(teacherDetails.getLastName());
		teacherProxy.updateTeacherData(teacher);
		return ResponseEntity.ok("Teacher Data updated Successfully");
	}

	@DeleteMapping("/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Map<String, Boolean>> deleteTeacherData(@PathVariable(value = "id") String teacherId) {
		LOGGER.info("Inside getTeacherById() AuthApiTeacherController => " + teacherId);
		Teacher teacher = teacherProxy.getTeacherById(teacherId).orElseThrow(() -> new ResourceNotFoundException());
		User user = userProxy.findByUsername(teacher.getEmail());
		teacherProxy.deleteTeacherData(teacherId);
		userProxy.deleteById(user.getId());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
