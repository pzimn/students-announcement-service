package com.student.service.web.service.facade.api;

import com.student.service.web.model.Announcement;

import java.util.List;

public interface AnnouncementService {

    Announcement findById(Integer id);

    void saveAnnouncement(Announcement announcement);

    void updateAnnouncement(Announcement announcement);

    void deleteAnnouncementById(Integer id);

    void deleteAllAnnouncements();

    List<Announcement> findAllAnnouncements();

    boolean isAnnouncementExist(Announcement announcement);
}