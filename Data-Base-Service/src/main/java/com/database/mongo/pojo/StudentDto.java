package com.database.mongo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	private String FirstName;
	private String lastName;
	private String dob;
	private String address;
	private String email;
	private String password;
	private String dateOfAdmission;
}
