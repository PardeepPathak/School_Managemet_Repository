package com.database.mongo.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongo.Model.Parents;
import com.database.mongo.serviceImple.ParentsServiceImplementation;



@RestController
@RequestMapping("/parents")
public class ParentsController {
	@Autowired
	private ParentsServiceImplementation parentsServiceImplementation;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ParentsController.class);
	
	
	@GetMapping
	public List<Parents> getAllParentsDetails(){
		LOGGER.info("InSide getAllParentsDetails() Method");
		return parentsServiceImplementation.getAllParentsDetails();
	}
	
	@PostMapping
	public String addParentsData(@RequestBody Parents parents) {
		 parentsServiceImplementation.addParentsDetails(parents);
			LOGGER.info("InSide addParentsData() Method");
		 return "Parents Details Added SuccessFully";
		
	}
	
	@PutMapping
	public String updateParentsDetails(@RequestBody Parents parents) {
		parentsServiceImplementation.updateParentsDetails(parents);
		LOGGER.info("InSide updateParentsDetails() Method");
		return "Parents Details Updated SuccessFully";
		
	}
	
	@GetMapping("/{id}")
	public Optional<Parents> getParentsDetailsById(@PathVariable String id){
		LOGGER.info("InSide getParentsDetailsById() Method");
		return parentsServiceImplementation.getParentsDetailsById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteParentsDetails(@PathVariable String id) {
		LOGGER.info("InSide deleteParentsDetails() Method");
		parentsServiceImplementation.deleteParentsDetails(id);
		return "Parents Detail Deleted SuccessFully";
	}
	

}
