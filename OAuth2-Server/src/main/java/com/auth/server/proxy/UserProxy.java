package com.auth.server.proxy;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.auth.server.pojo.User;

@FeignClient(name = "Data-Base-Service")
public interface UserProxy {
	@PostMapping("/user")
	public void saveUserData(@RequestBody User user);
	@GetMapping("/user/{email}")
	public User findByUsername(@PathVariable("email") String email);
	@GetMapping("/user/email/{email}")
	public boolean existByEmail(@PathVariable("email") String email);
	@DeleteMapping("/user/{id}")
	public void deleteById(@PathVariable("id") String id);
}
