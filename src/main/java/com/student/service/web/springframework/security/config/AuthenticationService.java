package com.student.service.web.springframework.security.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.student.service.web.model.User;
import com.student.service.web.service.facade.api.UserService;



@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		UserDetails userDetail = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(authority));
		return userDetail;
	}

}