package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongo.Model.Teacher;
import com.database.mongo.repository.TeacherRepo;
import com.database.mongo.service.TeacherService;

@Service
public class TeacherServiceImple implements TeacherService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImple.class);

	@Autowired
	private TeacherRepo teacherRepo;

	@Override
	public List<Teacher> getAllTeacherData() {
		LOGGER.info("Inside getAllTeacherData()");
		return teacherRepo.findAll();
	}

	@Override
	public Teacher addNewTeacher(Teacher teacher) {
		LOGGER.info("Inside addNewTeacher()" + teacher);
		return teacherRepo.save(teacher);
	}

	@Override
	public Teacher updateTeacherData(Teacher teacher) {
		LOGGER.info("Inside updateTeacherData()" + teacher);
		return teacherRepo.save(teacher);
	}

	@Override
	public void deleteTeaherDataById(String id) {
		LOGGER.info("Inside deleteTeaherDataById()" + id);
		teacherRepo.deleteById(id);

	}

	@Override
	public Optional<Teacher> getTeacherById(String id) {
		LOGGER.info("Inside getTeacherById()" + id);
		return teacherRepo.findById(id);

	}

}
