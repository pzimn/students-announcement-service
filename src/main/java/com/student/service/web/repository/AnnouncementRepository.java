package com.student.service.web.repository;

import com.student.service.web.model.Announcement;
import com.student.service.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
