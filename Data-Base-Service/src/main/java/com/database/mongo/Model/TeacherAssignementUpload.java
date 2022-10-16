package com.database.mongo.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "TeacherAssignements")
@NoArgsConstructor
@Getter
@Setter
public class TeacherAssignementUpload {
	private String id;
	private String fileName;
	private String fileType;
	
	private byte[] data;

	public TeacherAssignementUpload(String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

}
