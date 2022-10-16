package com.database.mongo.serviceImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.database.mongo.Model.TeacherAssignementUpload;
import com.database.mongo.repository.TeacherAssignementRepo;

@Service
public class TeacherAssignementServiceImple {
	@Autowired
	private TeacherAssignementRepo teacherAssignementRepo;
	
	 
	  public TeacherAssignementUpload saveFile(MultipartFile file) {
		  String docname = file.getOriginalFilename();
		  try {
			  TeacherAssignementUpload assignemnt = new TeacherAssignementUpload(docname,file.getContentType(),file.getBytes());
			  return teacherAssignementRepo.save(assignemnt);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return null;
	  }
	  public Optional<TeacherAssignementUpload> getFile(String  fileId) {
		  return teacherAssignementRepo.findById(fileId);
	  }
	  public List<TeacherAssignementUpload> getFiles(){
		  return teacherAssignementRepo.findAll();
	  }
	}

