package com.database.mongo.service;

import java.util.List;
import java.util.Optional;
import com.database.mongo.Model.Subject;

public interface SubjectService {
	public List<Subject> getAllSubject();
	public Subject addSubject(Subject subject);
	public Subject updateSubject(Subject subject);
	public void deleteSubject(String id);
	public Optional<Subject> getSubjectById(String id);
}
