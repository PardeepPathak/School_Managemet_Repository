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

import com.database.mongo.Model.Subject;
import com.database.mongo.serviceImple.SubjectServiceImple;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);

	@Autowired
	private SubjectServiceImple subjectServiceImple;

	@GetMapping
	public List<Subject> getAllSubject() {
		LOGGER.info("inside  getAllSubject()");
		return subjectServiceImple.getAllSubject();
	}

	@PostMapping
	public String addSubject(@RequestBody Subject subject) {
		LOGGER.info("inside  addSubject()" + subject);
		subjectServiceImple.addSubject(subject);
		return "Subject Add Successfully";
	}

	@PutMapping
	public String UpdateSubject(@RequestBody Subject subject) {
		LOGGER.info("inside  UpdateSubject()" + subject);
		subjectServiceImple.updateSubject(subject);
		return "Subject update Successfully";
	}

	@DeleteMapping("/{id}")
	public String deleteSubject(@PathVariable String id) {
		LOGGER.info("inside  deleteSubject()" + id);
		subjectServiceImple.deleteSubject(id);
		return "Subject Deleted SuccessFully";
	}

	@GetMapping("/{id}")
	public Optional<Subject> getSubjectById(@PathVariable String id) {
		LOGGER.info("inside  getSubjectById()" + id);
		Optional<Subject> subject = subjectServiceImple.getSubjectById(id);
		LOGGER.info("inside  getSubjectById()" + subject);
		if (subject == null)
			return null;
		else
			return subject;
	}
}
