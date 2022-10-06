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

import com.auth.server.pojo.Teacher;

@FeignClient(name = "Teacher-Service")
public interface TeacherProxy {
	@PostMapping("/teacher")
	public void addNewTeacher(@RequestBody Teacher teacher);

	@GetMapping("/teacher")
	public List<Teacher> getAllTeacher();

	@PutMapping("/teacher")
	public String updateTeacherData(@RequestBody Teacher teacher);

	@DeleteMapping("/teacher/{id}")
	public void deleteTeacherData(@PathVariable("id") String id);

	@GetMapping("/teacher/{id}")
	public Optional<Teacher> getTeacherById(@PathVariable("id") String id);
}
