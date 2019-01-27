package com.student.service.web.controller;

import com.student.service.web.model.User;
import com.student.service.web.service.facade.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	UserService userService;

	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/user")
	public ResponseEntity<?> getUser(Principal principal) {
		if (principal != null)
			return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.ACCEPTED);

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	// Get All Users
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(Principal principal) {
		if (principal == null || userService.findByUsername(principal.getName()).getRole() != User.ROLE_ADMIN)
			return new ResponseEntity<>(userService.findAll(), HttpStatus.ACCEPTED);

		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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
		logger.info("Retrieved user from DB: {}. ", user);
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
	
	@PostMapping("/register")
	public ResponseEntity<?> registerValidUser(@RequestBody @Valid User user, BindingResult bindingResult) {
		
		if (userService.findByUsername(user.getUsername()) != null)
			bindingResult.addError(new FieldError("user", "username", "Nazwa użytkownika jest zajęta!"));
		if (userService.findByEmail(user.getEmail()) != null)
			bindingResult.addError(new FieldError("user", "email", "Podany email istnieje w bazie!"));
		if (!Pattern.compile(User.PASSWORD_PATTERN).matcher(user.getPassword()).matches())
			bindingResult.addError(new FieldError("user", "password",
					"Hasło nie może zawierać spacji (6-15 znaków)"));
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(errorResponseBuilder(bindingResult), HttpStatus.BAD_REQUEST);
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	public Map<String, Object> errorResponseBuilder(BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<String, Object>();
		Map<String, String> errors = new HashMap<String, String>();

		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		response.put("error", errors);
		return response;
	}

}
