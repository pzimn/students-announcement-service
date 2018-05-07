package com.student.service.web.service.facade.api;

import com.student.service.web.model.School;

import java.util.List;

public interface SchoolService {

    School findOne(Integer id);

    School findByName(String name);

    School save(School school);

    void update(School school);

    void deleteById(Integer id);

    void deleteAll();

    List<School> findAll();
}

