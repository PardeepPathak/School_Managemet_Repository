package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongo.Model.School;
import com.database.mongo.repository.SchoolRepo;
import com.database.mongo.service.SchoolService;
@Service
public class SchoolServiceImple implements SchoolService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolServiceImple.class);
	
	@Autowired
	private SchoolRepo schoolRepo;
	
	
	@Override
	public List<School> getSchoolData() {
		
		LOGGER.info("Inside getSchoolData()");
		
		return schoolRepo.findAll();
	}

	@Override
	public School addDataToSchool(School school) {
		LOGGER.info("Inside addDataToSchool() => "+school);
		return schoolRepo.save(school);
	}

	@Override
	public School updateSchoolData(School school) {
		LOGGER.info("Inside updateSchoolData() => "+school);
		return schoolRepo.save(school);
	}

	@Override
	public void deleteDataFromSchoolById(String id) {
		LOGGER.info("Inside deleteDataFromSchoolById() => "+id);
		schoolRepo.deleteById(id);
		
	}

	@Override
	public Optional<School> getSchoolDataById(String id) {
		LOGGER.info("Inside getSchoolDataById() => "+id);
		return schoolRepo.findById(id);
	}

}
