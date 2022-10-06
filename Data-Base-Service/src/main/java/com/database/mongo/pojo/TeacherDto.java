package com.database.mongo.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
	private String firstName;
	private String lastName;
	private String dob;
	private String address;
	private String email;
	private String password;
	private String qualification;
	private String dateOfJoining;

}
