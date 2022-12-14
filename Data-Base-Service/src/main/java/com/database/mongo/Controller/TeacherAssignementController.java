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

import com.database.mongo.Model.TeacherAssignementUpload;
import com.database.mongo.serviceImple.TeacherAssignementServiceImple;

@RestController
@RequestMapping("/teacherAssignement")
@CrossOrigin("*")
public class TeacherAssignementController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherAssignementController.class);
	
	@Autowired
	private TeacherAssignementServiceImple teacherAssignementServiceImple;
	
	@GetMapping
	public List<TeacherAssignementUpload> getAllAssignements() {
		LOGGER.info("INSIDE TeacherAssignementController getAllAssignements()");
		List<TeacherAssignementUpload> files= teacherAssignementServiceImple.getFiles();
		return files;
	}

	@PostMapping("/uploadFiles")
	public ResponseEntity<?> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) throws InterruptedException {
		Thread.sleep(5000);
		LOGGER.info("INSIDE TeacherAssignementController uploadMultipleFiles()");
		for (MultipartFile file: files) {
			LOGGER.info("INSIDE TeacherAssignementController uploadMultipleFiles()");
			teacherAssignementServiceImple.saveFile(file);
		}
		LOGGER.info("INSIDE TeacherAssignementController uploadMultipleFiles() completed");
		return ResponseEntity.ok("File Uploaded SuccessFully");
	}
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileId){
		LOGGER.info("INSIDE TeacherAssignementController downloadFile()");
		TeacherAssignementUpload doc = teacherAssignementServiceImple.getFile(fileId).get();
		LOGGER.info("INSIDE TeacherAssignementController downloadFile() Downloaded successfully");
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getFileName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}

}
