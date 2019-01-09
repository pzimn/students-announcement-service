package com.student.service.web.repository;

import com.student.service.web.model.Announcement;
import com.student.service.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

    @Query("SELECT a FROM Announcements a WHERE a.category_id = :id")
    public List<Announcement> findAllWithId(@Param("id") Integer id);

    @Query("SELECT a FROM Announcements a WHERE a.category_id <= :id")
    public List<Announcement> findAllDownParentCategory(@Param("id") Integer id);
}
