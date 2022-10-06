package com.database.mongo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
  @Id
  private String id;
  private ERole name;
}
