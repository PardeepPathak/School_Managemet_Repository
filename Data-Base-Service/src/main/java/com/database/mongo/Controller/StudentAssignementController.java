package com.database.mongo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.database.mongo.Model.StudentAssignement;
import com.database.mongo.serviceImple.StudentAssignementServiceImple;
@CrossOrigin("*")
@RestController
@RequestMapping("/studentAssignement")
public class StudentAssignementController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentAssignementController.class);
	
	@Autowired
	private StudentAssignementServiceImple studentAssignementServiceImple;
	
	@GetMapping
	public List<StudentAssignement> getAllAssignements() {
		LOGGER.info("INSIDE StudentAssignementController getAllAssignements()");
		List<StudentAssignement> files= studentAssignementServiceImple.getFiles();
		return files;
	}

	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		LOGGER.info("INSIDE StudentAssignementController uploadMultipleFiles()");
		for (MultipartFile file: files) {
			LOGGER.info("INSIDE StudentAssignementController uploadMultipleFiles()");
			studentAssignementServiceImple.saveFile(file);
			
		}
		LOGGER.info("INSIDE StudentAssignementController uploadMultipleFiles() completed");
		return "file uploaded successfully";
	}
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileId){
		LOGGER.info("INSIDE StudentAssignementController downloadFile()");
		StudentAssignement doc = studentAssignementServiceImple.getFile(fileId).get();
		LOGGER.info("INSIDE StudentAssignementController downloadFile() Downloaded successfully");
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getFileName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}


}
