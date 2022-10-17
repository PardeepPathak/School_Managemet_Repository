package com.teacher.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.teacher.pojo.Teacher;

@FeignClient(name = "Data-Base-Service")
public interface TeacherProxy {
	@GetMapping("/teacher")
	public List<Teacher> getAllTeacherData();
	@PutMapping("/teacher")
	public String updateTeacherData(@RequestBody Teacher student);
	@DeleteMapping("/teacher/{id}")
	public void deleteTeacher(@PathVariable("id")String id);
	@PostMapping("/teacher")
	public String addNewTeacher(@RequestBody Teacher student);
	@GetMapping("/teacher/{id}")
	public Optional<Teacher> getTeacherById(@PathVariable("id") String id);
}
