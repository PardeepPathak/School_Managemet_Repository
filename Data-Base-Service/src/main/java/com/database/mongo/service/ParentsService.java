package com.database.mongo.service;

import java.util.List;
import java.util.Optional;

import com.database.mongo.Model.Parents;

public interface ParentsService {
	public List<Parents> getAllParentsDetails();
	public Parents addParentsDetails(Parents parents);
	public Parents updateParentsDetails(Parents parents);
	public void deleteParentsDetails(String id);
	public Optional<Parents> getParentsDetailsById(String id);

}
