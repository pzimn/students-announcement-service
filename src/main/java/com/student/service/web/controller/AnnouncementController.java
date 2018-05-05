package com.student.service.web.controller;

import com.student.service.web.model.Announcement;
import com.student.service.web.repository.AnnouncementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnnouncementController {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    AnnouncementRepository announcementRepository;

    // Get All Announcements
    @GetMapping("/announcements")
    public List<Announcement> getAllAnnouncement() {
        return announcementRepository.findAll();
    }

    // Create a new Announcement
    @PostMapping("/announcements")
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        logger.info("Saving announcement: {}. ", announcement);
        return announcementRepository.save(announcement);
    }

    // Get a Single Announcement
    @GetMapping("/announcements/{id}")
    public Announcement getAnnouncementById(@PathVariable(value = "id") Integer announcementId) {
        Announcement announcement = announcementRepository.findOne(announcementId);
        logger.info("Retrieved user from DB: {}. ",announcement);
        return announcement;
    }

    // Update a Announcement
    @PutMapping("/announcements")
    public Announcement updateAnnouncement(@RequestBody Announcement announcement) {
        logger.info("Updating announcement in DB: {}. ", announcement);
        announcementRepository.save(announcement);
        logger.info("Updated announcement in DB: {}. ", announcement);
        return announcement;
    }

    // Delete a Announcement
    @DeleteMapping("/announcements/{id}")
    public void deleteAnnouncement(@PathVariable("id") Integer announcementId) {
        logger.info("Deleting announcement from DB with ID: {}. ", announcementId);
        announcementRepository.delete(announcementId);
    }

}
