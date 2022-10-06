package com.auth.server.proxy;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.auth.server.pojo.ERole;
import com.auth.server.pojo.Role;

@FeignClient(name = "Data-Base-Service")
public interface RoleProxy {
	@GetMapping("/role/{name}")
	public Optional<Role> getRole(@PathVariable ERole name);

}
