package com.student.service.web.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.web.model.Announcement;
import com.student.service.web.model.User;
import com.student.service.web.service.facade.api.AnnouncementService;
import com.student.service.web.service.facade.api.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	UserService userService;

	@Autowired
	AnnouncementService announcementService;

	@GetMapping("/")
	public String helloWorld(){
		return "layout";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@RequestMapping("/user")
	public Principal user(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization")
				.substring("Basic".length()).trim();
		return () ->  new String(Base64.getDecoder()
				.decode(authToken)).split(":")[0];
	}

	@GetMapping("user/{id}/announcements")
	public ResponseEntity<?> getAllAnnouncementByUser(@PathVariable int id) {
		if (userService.findOne(id) == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Announcement>>(announcementService.findAll().stream().filter(user -> user.getUserId() == id)
				.collect(Collectors.toList()), HttpStatus.ACCEPTED);
	}

	// Get All Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	// Create a new User
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		logger.info("Saving user: {}. ", user);
		return userService.save(user);
	}

	// Get a Single User
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Integer userId) {
		User user = userService.findOne(userId);
		logger.info("Retrieved user from DB: {}. ",user);
		return user;
	}

	// Update a User
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		logger.info("Updating user in DB: {}. ", user);
		userService.save(user);
		logger.info("Updated user in DB: {}. ", user);
		return user;
	}

	// Delete a User
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") Integer userId) {
		logger.info("Deleting user from DB with ID: {}. ", userId);

	}

}
