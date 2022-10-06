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

import com.database.mongo.Model.School;
import com.database.mongo.serviceImple.SchoolServiceImple;

@RestController
@RequestMapping("/school")
public class SchoolController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolController.class);

	@Autowired
	private SchoolServiceImple schoolServiceImple;

	@GetMapping
	public List<School> getSchoolData() {
		LOGGER.info("Inside  getSchoolData()");
		List<School> schoolData = schoolServiceImple.getSchoolData();
		return schoolData;
	}

	@PostMapping
	public String createSchoolData(@RequestBody School school) {
		LOGGER.info("Inside  createSchoolData()" + school);
		schoolServiceImple.addDataToSchool(school);
		return "School Data added SuccessFully";
	}

	@PutMapping
	public String updateSchoolData(@RequestBody School school) {
		LOGGER.info("Inside  updateSchoolData()" + school);
		schoolServiceImple.updateSchoolData(school);
		return "School Data updated Successfully";
	}

	@DeleteMapping("/{id}")
	public String deleteSchoolData(@PathVariable String id) {
		LOGGER.info("Inside  deleteSchoolData()" + id);
		schoolServiceImple.deleteDataFromSchoolById(id);
		return "School Data deleted SuccessFully";
	}

	@GetMapping("/{id}")
	public Optional<School> getSchoolById(@PathVariable String id) {
		LOGGER.info("Inside  getSchoolById()" + id);
		Optional<School> schoolData = schoolServiceImple.getSchoolDataById(id);
		LOGGER.info("Inside  getSchoolById()" + id);
		if (schoolData == null)
			return null;
		else
			return schoolData;
	}

}
