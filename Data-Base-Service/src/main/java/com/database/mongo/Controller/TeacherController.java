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

import com.database.mongo.Model.Teacher;
import com.database.mongo.serviceImple.TeacherServiceImple;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	private static final Logger LOGGER =  LogManager.getLogger(TeacherController.class);

	@Autowired
	private TeacherServiceImple teacherServiceImple;

	@GetMapping
	public List<Teacher> getAllTeacher() {
		LOGGER.info("inside getAllTeacher()");
		return teacherServiceImple.getAllTeacherData();
	}

	@PostMapping
	public String registerTeacher(@RequestBody Teacher teacher) {
		LOGGER.info("inside registerTeacher()" + teacher);
		teacherServiceImple.addNewTeacher(teacher);
		return "Teacher Added SuccessFully";

	}

	@PutMapping
	public String updateTeacherData(@RequestBody Teacher teacher) {
		LOGGER.info("inside updateTeacherData()" + teacher);
		teacherServiceImple.updateTeacherData(teacher);
		return "Teacher Data Updated SuccessFully";
	}

	@DeleteMapping("/{id}")
	public void deletTeacherData(@PathVariable String id) {
		LOGGER.info("inside deletTeacherData()" + id);
		teacherServiceImple.deleteTeaherDataById(id);

	}

	@GetMapping("/{id}")
	public Optional<Teacher> getTeacherById(@PathVariable String id) {
		LOGGER.info("inside  getTeacherById()" + id);
		Optional<Teacher> teacher = teacherServiceImple.getTeacherById(id);
		if (teacher != null)
			return teacher;
		else
			return null;
	}

}
