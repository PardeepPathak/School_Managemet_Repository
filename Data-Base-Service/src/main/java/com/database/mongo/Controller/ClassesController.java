package com.database.mongo.Controller;

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

import com.database.mongo.Model.Classes;
import com.database.mongo.serviceImple.ClassesServiceImple;

@RestController
@RequestMapping("/classes")
public class ClassesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClassesController.class);

	@Autowired
	private ClassesServiceImple classesImple;

	@GetMapping
	public List<Classes> getAllClasses() {
		LOGGER.info("Inside getAllClasses()");
		return classesImple.getAllClassesData();
	}

	@PostMapping
	public String createClassesData(@RequestBody Classes classes) {
		LOGGER.info("Inside createClassesData()" + classes);
		classesImple.createClasses(classes);
		return "Class Data created SuccessFully";
	}

	@PutMapping
	public String updateClass(@RequestBody Classes classes) {
		LOGGER.info("Inside updateClass()" + classes);
		classesImple.updateClasses(classes);
		return "Class Data updated SuccessFully";
	}

	@DeleteMapping("/{id}")
	public String deleteClassData(@PathVariable String id) {
		LOGGER.info("Inside deleteClassData()" + id);
		classesImple.deleteClasses(id);
		return "Class Data deleted Succesfully";
	}

	@GetMapping("/{id}")
	public Optional<Classes> getClassById(@PathVariable String id) {
		LOGGER.info("Inside getClassById()" + id);
		Optional<Classes> classData = classesImple.getClassById(id);
		LOGGER.info("Inside getClassById()" + id);
		if (classData == null)
			return null;
		else
			return classData;
	}

}
