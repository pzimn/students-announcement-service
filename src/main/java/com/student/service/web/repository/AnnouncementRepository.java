package com.student.service.web.repository;

import com.student.service.web.model.Announcement;
import org.springframework.data.repository.CrudRepository;

public interface AnnouncementRepository extends CrudRepository<Announcement, Integer> {
}
