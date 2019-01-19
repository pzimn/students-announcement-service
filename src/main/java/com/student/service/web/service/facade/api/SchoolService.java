package com.student.service.web.service.facade.api;

import com.student.service.web.model.School;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface SchoolService extends JpaRepository<School, Integer>{

    School findByName(String name);
    void deleteById(Integer id);
}

