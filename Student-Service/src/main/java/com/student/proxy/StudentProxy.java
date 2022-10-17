package com.student.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.student.pojo.Student;

@FeignClient(name = "Data-Base-Service")
public interface StudentProxy {
	@GetMapping("/student")
	public List<Student> getAllStudentData();
	@PutMapping("/student")
	public String updateStudentData(@RequestBody Student student);
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id")String id);
	@PostMapping("/student")
	public String addNewStudent(@RequestBody Student student);
	@GetMapping("/student/{id}")
	public Optional<Student> geStudentById(@PathVariable("id") String id);

}
