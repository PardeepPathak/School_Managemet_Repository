package com.database.mongo.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "StudentAssignements")
@NoArgsConstructor
@Getter
@Setter
public class StudentAssignement {
	
	private String id;
	private String fileName;
	private String fileType;
	
	private byte[] data;

	public StudentAssignement(String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}


}
