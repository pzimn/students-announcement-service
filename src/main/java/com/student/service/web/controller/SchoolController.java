package com.student.service.web.controller;

import com.student.service.web.model.School;
import com.student.service.web.service.facade.api.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class SchoolController {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    SchoolService schoolService;

    // Get All Schools
    @GetMapping("/schools")
    public List<School> getAllSchools() {
        return schoolService.findAll();
    }

    // Create a new School
    @PostMapping("/schools")
    public School createSchool(@RequestBody School school) {
        logger.info("Saving school: {}. ", school);
        return schoolService.save(school);
    }

    // Get a Single School
    @GetMapping("/schools/{id}")
    public School getSchoolById(@PathVariable(value = "id") Integer schoolId) {
        School school = schoolService.findOne(schoolId);
        logger.info("Retrieved user from DB: {}. ",school);
        return school;
    }

    // Update a School
    @PutMapping("/schools")
    public School updateSchool(@RequestBody School school) {
        logger.info("Updating school in DB: {}. ", school);
        schoolService.save(school);
        logger.info("Updated school in DB: {}. ", school);
        return school;
    }

    // Delete a School
    @DeleteMapping("/schools/{id}")
    public void deleteSchool(@PathVariable("id") Integer schoolId) {
        logger.info("Deleting school from DB with ID: {}. ", schoolId);
        schoolService.deleteById(schoolId);
    }

}

