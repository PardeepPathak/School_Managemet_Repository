package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.database.mongo.Model.TeacherAssignementUpload;
import com.database.mongo.repository.TeacherAssignementRepo;

@Service
public class TeacherAssignementServiceImple {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherAssignementServiceImple.class);
	
	@Autowired
	private TeacherAssignementRepo teacherAssignementRepo;
	
	 
	  public TeacherAssignementUpload saveFile(MultipartFile file) {
		  LOGGER.info("INSIDE TeacherAssignementServiceImple method saveFile()");
		  String docname = file.getOriginalFilename();
		  try {
			  TeacherAssignementUpload assignemnt = new TeacherAssignementUpload(docname,file.getContentType(),file.getBytes());
			  return teacherAssignementRepo.save(assignemnt);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  LOGGER.info("INSIDE TeacherAssignementServiceImple method saveFile() completed");
		  return null;
	  }
	  public Optional<TeacherAssignementUpload> getFile(String  fileId) {
		  LOGGER.info("INSIDE TeacherAssignementServiceImple method getFile()");
		  return teacherAssignementRepo.findById(fileId);
	  }
	  public List<TeacherAssignementUpload> getFiles(){
		  LOGGER.info("INSIDE TeacherAssignementServiceImple method getFiles()");
		  return teacherAssignementRepo.findAll();
	  }
	}

