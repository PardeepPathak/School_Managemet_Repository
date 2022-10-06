package com.auth.server.request;

import java.util.Set;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
	@Email
	private String email;
	private String password;
	private Set<String> roles;
	
}
