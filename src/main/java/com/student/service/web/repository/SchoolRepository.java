package com.student.service.web.repository;

import com.student.service.web.model.School;
import com.student.service.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    School findByName(String name);
}
