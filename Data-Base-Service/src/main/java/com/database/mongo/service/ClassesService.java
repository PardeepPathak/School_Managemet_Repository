package com.database.mongo.service;

import java.util.List;
import java.util.Optional;

import com.database.mongo.Model.Classes;
import com.database.mongo.pojo.ClassesDto;

public interface ClassesService {
	public List<Classes> getAllClassesData();
	public Classes createClasses(Classes classes);
	public Classes updateClasses(Classes classes);
	public void deleteClasses(String classId);
	public Optional<Classes> getClassById(String classId);
}
