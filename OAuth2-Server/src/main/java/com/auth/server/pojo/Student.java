package com.auth.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	private String studentId;
	private String FirstName;
	private String lastName;
	private String userRole;
	private String dob;
	private String address;
	private String email;
	private String password;
	private String dateOfAdmission;
	public Student(String firstName, String lastName, String userRole, String dob, String address, String email,
			String password, String dateOfAdmission) {
		super();
		FirstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.password = password;
		this.dateOfAdmission = dateOfAdmission;
	}
	
}

