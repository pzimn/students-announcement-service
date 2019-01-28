package com.student.service.web.controller;

import com.student.service.web.model.Announcement;
import com.student.service.web.service.facade.api.AnnouncementService;
import com.student.service.web.service.facade.api.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AnnouncementController {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	AnnouncementService announcementService;

	@Autowired
	UserService userService;

	// Get All Announcements
	@GetMapping("/myAnnouncements")
	public ResponseEntity<?> getAllAnnouncementByUser(Principal principal) {
		if (principal == null)
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		int userId = userService.findByUsername(principal.getName()).getId();
		return new ResponseEntity<List<Announcement>>(announcementService.findAll().stream().filter(user -> user.getUserId() == userId)
				.collect(Collectors.toList()), HttpStatus.ACCEPTED);
	}

	@GetMapping("/announcements")
	public List<Announcement> getAllAnnouncement() {
		return announcementService.findAll();
	}

	// Create a new Announcement
	@PostMapping("/announcements")
	public Announcement createAnnouncement(@RequestBody Announcement announcement) {
		logger.info("Saving announcement: {}. ", announcement);
		return announcementService.save(announcement);
	}

	// Get a Single Announcement
	@GetMapping("/announcements/{id}")
	public List<Announcement> getAnnouncementById(@PathVariable(value = "id") Integer announcementId) {
		List<Announcement> announcement = announcementService.findAllDownParentCategory(announcementId);
		logger.info("Retrieved user from DB: {}. ", announcement);
		return announcement;
	}

	// Update a Announcement
	@PutMapping("/announcements")
	public Announcement updateAnnouncement(@RequestBody Announcement announcement) {
		logger.info("Updating announcement in DB: {}. ", announcement);
		announcementService.save(announcement);
		logger.info("Updated announcement in DB: {}. ", announcement);
		return announcement;
	}

	// Delete a Announcement
	@DeleteMapping("/announcements/{id}")
	public void deleteAnnouncement(@PathVariable("id") Integer announcementId) {
		logger.info("Deleting announcement from DB with ID: {}. ", announcementId);
		announcementService.deleteById(announcementId);
	}

}
