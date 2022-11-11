package com.database.mongo.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Parents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Parents {
	private String id;
	private String studentName;
	private String fatherName;
	private String motherName;
	private Integer contact;
	private String emailId;
	public Parents(String studentName, String fatherName, String motherName, Integer contact, String emailId) {
		super();
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.contact = contact;
		this.emailId = emailId;
	}
	

}
