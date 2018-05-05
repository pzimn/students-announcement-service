package com.student.service.web.controller;

import com.student.service.web.model.User;
import com.student.service.web.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    UserRepository userRepository;

    // Get All Users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create a new User
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        logger.info("Saving user: {}. ", user);
        return userRepository.save(user);
    }

    // Get a Single User
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Integer userId) {
        User user = userRepository.findOne(userId);
        logger.info("Retrieved user from DB: {}. ",user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        logger.info("Updating user in DB: {}. ", user);
        userRepository.save(user);
        logger.info("Updated user in DB: {}. ", user);
        return user;
    }

    // Delete a User
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Integer userId) {
        logger.info("Deleting user from DB with ID: {}. ", userId);
        userRepository.delete(userId);
    }

}
