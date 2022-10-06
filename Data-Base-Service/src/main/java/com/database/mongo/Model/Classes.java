package com.database.mongo.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Classes {
	@Id
	private String  Id;
	private String  className;

}
