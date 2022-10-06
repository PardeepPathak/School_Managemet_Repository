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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
	@Id
	private String teacherId;
	private String firstName;
	private String lastName;
	private String UserRole;
	private String dob;
	private String address;
	private String email;
	private String password;
	private String dateOfJoining;

}
