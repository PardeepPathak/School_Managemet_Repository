package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongo.Model.Subject;
import com.database.mongo.repository.SubjectRepo;
import com.database.mongo.service.SubjectService;

@Service
public class SubjectServiceImple implements SubjectService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectServiceImple.class);

	@Autowired
	private SubjectRepo subjectRepo;

	@Override
	public List<Subject> getAllSubject() {
		LOGGER.info("Inside getAllSubject()");
		return subjectRepo.findAll();
	}

	@Override
	public Subject addSubject(Subject subject) {
		LOGGER.info("Inside addSubject()" + subject);
		return subjectRepo.save(subject);
	}

	@Override
	public Subject updateSubject(Subject subject) {
		LOGGER.info("Inside updateSubject()" + subject);
		return subjectRepo.save(subject);
	}

	@Override
	public void deleteSubject(String id) {
		LOGGER.info("Inside deleteSubject()" + id);
		subjectRepo.deleteById(id);

	}

	@Override
	public Optional<Subject> getSubjectById(String id) {
		LOGGER.info("Inside getSubjectById()" + id);
		return subjectRepo.findById(id);
	}

}
