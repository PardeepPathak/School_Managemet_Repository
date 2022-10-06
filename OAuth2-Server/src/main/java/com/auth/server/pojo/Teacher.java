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
public class Teacher {

	private String teacherId;
	private String firstName;
	private String lastName;
	private String UserRole;
	private String dob;
	private String address;
	private String email;
	private String password;
	private String dateOfJoining;
	public Teacher(String firstName, String lastName, String userRole, String dob, String address, String email,
			String password, String dateOfJoining) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		UserRole = userRole;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.password = password;
		this.dateOfJoining = dateOfJoining;
	}

}

