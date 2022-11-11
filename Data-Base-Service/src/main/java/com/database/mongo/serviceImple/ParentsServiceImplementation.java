package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongo.Model.Parents;
import com.database.mongo.repository.ParentsRepository;
import com.database.mongo.service.ParentsService;

@Service
public class ParentsServiceImplementation implements ParentsService{
	
	@Autowired
	private ParentsRepository parentsRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ParentsServiceImplementation.class);

	@Override
	public List<Parents> getAllParentsDetails() {
		LOGGER.info("Inside the getAllParentsDetails() Method");
		return parentsRepository.findAll();
	}

	@Override
	public Parents addParentsDetails(Parents parents) {
		LOGGER.info("Inside the addParentsDetails() Method");
		return parentsRepository.save(parents);
	}

	@Override
	public Parents updateParentsDetails(Parents parents) {
		LOGGER.info("Inside the updateParentsDetails() Method");
		return parentsRepository.save(parents);
	}

	@Override
	public void deleteParentsDetails(String id) {
		LOGGER.info("Inside the deleteParentsDetails() Method");
		parentsRepository.deleteById(id);
		
	}

	@Override
	public Optional<Parents> getParentsDetailsById(String id) {
		LOGGER.info("Inside the getParentsDetailsById() Method");
		return parentsRepository.findById(id);
	}

}
