package com.database.mongo.service;

import java.util.List;
import java.util.Optional;

import com.database.mongo.Model.Teacher;

public interface TeacherService {
	public List<Teacher> getAllTeacherData();
	public Teacher addNewTeacher(Teacher teacher);
	public Teacher updateTeacherData(Teacher teacher);
	public void deleteTeaherDataById(String id);
	public Optional<Teacher> getTeacherById(String id);
}
