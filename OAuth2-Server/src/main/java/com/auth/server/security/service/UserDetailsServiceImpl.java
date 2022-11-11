package com.auth.server.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.auth.server.pojo.User;
import com.auth.server.proxy.UserProxy;
import com.auth.server.utils.UserNotFoundExcept;

import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserProxy userProxy;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User	user  = userProxy.findByUsername(email);
//				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " +email));
		if(user==null)
			throw new UserNotFoundExcept();
		return UserDetailsImpl.build(user);
	}

}
