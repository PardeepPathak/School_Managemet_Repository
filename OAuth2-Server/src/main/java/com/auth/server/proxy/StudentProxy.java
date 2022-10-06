package com.auth.server.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.auth.server.pojo.Student;

@FeignClient(name = "Student-Service")
public interface StudentProxy {
	@PostMapping("/student")
	public void addNewStudentData(@RequestBody Student student);
	@GetMapping("/student")
	public List<Student> getAllStudent();
	@GetMapping("/student/email/{email}")
	public boolean existByEmail(@PathVariable("email") String email);
	@PutMapping("/student")
	public String updateStudentData(@RequestBody Student student);
	@DeleteMapping("/student/{id}")
	public String deleteStudentData(@PathVariable("id") String id);
	@GetMapping("/student/{id}")
	public Optional<Student> getStudentById(@PathVariable("id") String id);
}
