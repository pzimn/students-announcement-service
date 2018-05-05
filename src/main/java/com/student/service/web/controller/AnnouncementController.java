package com.student.service.web.controller;

import com.student.service.web.model.Announcement;
import com.student.service.web.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnouncementController {

    @Autowired
    AnnouncementRepository announcementRepository;

    // Get All Announcements
    @GetMapping("/announcements")
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

}
