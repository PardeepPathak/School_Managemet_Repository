package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongo.Model.Classes;
import com.database.mongo.repository.ClassesRepo;
import com.database.mongo.service.ClassesService;
@Service
public class ClassesServiceImple implements ClassesService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ClassesServiceImple.class);

	@Autowired
	private ClassesRepo classesRepo;
	
	@Override
	public List<Classes> getAllClassesData() {
		LOGGER.info("Inside  getAllClassesData()");
		return classesRepo.findAll();
	}

	@Override
	public Classes createClasses(Classes classes) {
		LOGGER.info("Inside  createClasses() => "+classes);
		return classesRepo.save(classes);
	}

	@Override
	public Classes updateClasses(Classes classes) {
		LOGGER.info("Inside  updateClasses() => "+classes);
		return classesRepo.save(classes);
	}

	@Override
	public void deleteClasses(String classId) {
		LOGGER.info("Inside  deleteClasses() => "+ classId);
		classesRepo.deleteById(classId);
		
	}

	@Override
	public Optional<Classes> getClassById(String classId) {
		LOGGER.info("Inside  getClassById() => "+classId);
		return classesRepo.findById(classId);
	}

}
