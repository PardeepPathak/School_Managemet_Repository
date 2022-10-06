package com.database.mongo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	@Id
	private String studentId;
	private String FirstName;
	private String lastName;
	private String userRole;
	private String dob;
	private String address;
	private String email;
	private String password;
	private String dateOfAdmission;
	

}
