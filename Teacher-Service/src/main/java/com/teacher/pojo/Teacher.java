package com.teacher.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
