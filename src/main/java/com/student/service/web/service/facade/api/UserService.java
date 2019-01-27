package com.student.service.web.service.facade.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.student.service.web.model.User;

@Service
public interface UserService extends JpaRepository<User, Integer> {

	public User findByUsername(String name);
	public User findByEmail(String email);

}