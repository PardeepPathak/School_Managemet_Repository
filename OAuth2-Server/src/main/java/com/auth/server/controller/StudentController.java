package com.auth.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.server.proxy.StudentProxy;
import com.auth.server.proxy.TeacherProxy;
import com.auth.server.proxy.UserProxy;
import com.auth.server.request.SignupRequest;
import com.auth.server.response.MessageResponse;
import com.auth.server.utils.ResourceNotFoundException;
import com.auth.server.utils.UserNotFoundExcept;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import com.auth.server.pojo.Student;
import com.auth.server.pojo.Teacher;
import com.auth.server.pojo.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentProxy proxy;

	@Autowired
	private UserProxy userProxy;

	@Autowired
	private AuthController auth;

	@Autowired
	private TeacherProxy teacherProxy;

	@Autowired
	PasswordEncoder encoder;

	@PostMapping
	public ResponseEntity<?> addUserData(@RequestBody Student student) {
		LOGGER.info("Inside addUserData() AuthApiTeacherController => " + student);
		if (userProxy.existByEmail(student.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("This email Address Already Exist!!"));
		}
		if (student.getUserRole().equalsIgnoreCase("Student")) {
			LOGGER.info("Inside addUserData() Student AuthApiStudnetController => " + student);
			Student std = new Student(student.getFirstName(), student.getLastName(), student.getUserRole(),
					student.getDob(), student.getAddress(), student.getEmail(), encoder.encode(student.getPassword()),
					student.getDateOfAdmission());
			Set<String> set = new HashSet<String>();
			set.add(student.getUserRole());
			SignupRequest sign = new SignupRequest(student.getEmail(), student.getPassword(), set);
			auth.registerUser(sign);
			proxy.addNewStudentData(std);
		} else {
			LOGGER.info("Inside addUserData() Teacher AuthApiStudnetController => " + student);
			Teacher teacher = new Teacher(student.getFirstName(), student.getLastName(), student.getUserRole(),
					student.getDob(), student.getAddress(), student.getEmail(), encoder.encode(student.getPassword()),
					student.getDateOfAdmission());
			teacherProxy.addNewTeacher(teacher);
			Set<String> set = new HashSet<String>();
			set.add(student.getUserRole());
			SignupRequest sign = new SignupRequest(student.getEmail(), student.getPassword(), set);
			auth.registerUser(sign);
		}
		return ResponseEntity.ok(new MessageResponse(student.getUserRole() + "User registered successfully!"));

	}

	@GetMapping
//	@PreAuthorize("hasRole('STUDENT') or hasRole('ADMIN') or hasRole('TEACHER')")
	@CircuitBreaker(name = "studentcontr", fallbackMethod = "studentContrFallback")
	@Retry(name = "studentcontr")
	@RateLimiter(name = "studentcontr")
	public List<Student> getallStudentData() {
		LOGGER.info("Inside getallStudentData() Student AuthApiStudentController => ");
		return proxy.getAllStudent();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Map<String, Boolean>> deleteStudentData(@PathVariable(value = "id") String studentId) {
		LOGGER.info("Inside deleteStudentData() Student AuthApiStudentController => " + studentId);
		Student student = proxy.getStudentById(studentId).orElseThrow(() -> new ResourceNotFoundException());
		User user = userProxy.findByUsername(student.getEmail());
		proxy.deleteStudentData(studentId);
		userProxy.deleteById(user.getId());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
//	@PreAuthorize("hasRole('STUDENT') or hasRole('ADMIN')")
	public ResponseEntity<?> updateStudentData(@PathVariable(value = "id") String studentId,
			@Valid @RequestBody Student studentDetails) {
		LOGGER.info("Inside updateStudentData() Student AuthApiStudentController => " + studentId);
		Student student = proxy.getStudentById(studentId).orElseThrow(() -> new ResourceNotFoundException());
		student.setAddress(studentDetails.getAddress());
		student.setDob(studentDetails.getDob());
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		proxy.updateStudentData(student);
		return ResponseEntity.ok("Student Updated SuccessFully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable String id) {
		LOGGER.info("Inside getStudentById() Student AuthApiStudentController => " + id);
		Student student = proxy.getStudentById(id).orElseThrow(() -> new ResourceNotFoundException());
		return ResponseEntity.ok(student);
	}

	public List<Student> studentContrFallback(Exception e) {
		LOGGER.warn("Inside studentContrFallback() Student AuthApiStudentController => " + e);
		List<Student> list = new ArrayList<Student>();
		Student std = new Student("Demo Firstname", "Demo Lastname", "jgjk", "anj", "am", "njaj", "ajj", "kk");
		list.add(std);
		return list;
	}
}
