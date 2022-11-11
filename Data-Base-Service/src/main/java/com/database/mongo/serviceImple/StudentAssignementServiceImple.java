package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.database.mongo.Model.StudentAssignement;
import com.database.mongo.repository.StudentAssignementRepo;

@Service
public class StudentAssignementServiceImple {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentAssignementServiceImple.class);
	
	@Autowired
	private StudentAssignementRepo studentAssignementRepo;
	
	 public StudentAssignement saveFile(MultipartFile file) {
		  LOGGER.info("INSIDE StudentAssignementServiceImple method saveFile()");
		  String docname = file.getOriginalFilename();
		  try {
			  StudentAssignement assignemnt = new StudentAssignement(docname,file.getContentType(),file.getBytes());
			  return studentAssignementRepo.save(assignemnt);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  LOGGER.info("INSIDE StudentAssignementServiceImple method saveFile() completed");
		  return null;
	  }
	  public Optional<StudentAssignement> getFile(String  fileId) {
		  LOGGER.info("INSIDE StudentAssignementServiceImple method getFile()");
		  return studentAssignementRepo.findById(fileId);
	  }
	  public List<StudentAssignement> getFiles(){
		  LOGGER.info("INSIDE StudentAssignementServiceImple method getFiles()");
		  return studentAssignementRepo.findAll();
	  }

}
