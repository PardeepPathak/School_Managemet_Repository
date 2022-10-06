package com.database.mongo.service;

import java.util.List;
import java.util.Optional;

import com.database.mongo.Model.School;
import com.database.mongo.pojo.SchoolDto;

public interface SchoolService {
	public List<School> getSchoolData();
	public School addDataToSchool(School school);
	public School updateSchoolData(School school);
	public void deleteDataFromSchoolById(String id);
	public Optional<School> getSchoolDataById(String id);	
}
