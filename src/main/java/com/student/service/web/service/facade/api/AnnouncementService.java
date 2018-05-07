package com.student.service.web.service.facade.api;

import com.student.service.web.model.Announcement;

import java.util.List;

public interface AnnouncementService {

    Announcement findOne(Integer id);

    Announcement save(Announcement announcement);

    void update(Announcement announcement);

    void deleteById(Integer id);

    void deleteAll();

    List<Announcement> findAll();

}