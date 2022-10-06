package com.database.mongo.Model;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
  @Id
  private String id;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  @NotBlank
  @Size(max = 120)
  private String password;
//  @DBRef
  private Set<Role> roles = new HashSet<>();
public User(@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password) {
	super();
	this.email = email;
	this.password = password;
}
  
}

