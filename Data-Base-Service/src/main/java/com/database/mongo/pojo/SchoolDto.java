package com.database.mongo.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SchoolDto {
	private String schoolName;
	private String studentFirstName;
	private String studentLastName;
	private String className;
	private String subject1;
	private String subject2;
	private String subject3;
	private String subject4;
	private String subject5;
	private String teacher1;
	private String teacher2;
	private String teacher3;
	private String teacher4;
	private String teacher5;
}
