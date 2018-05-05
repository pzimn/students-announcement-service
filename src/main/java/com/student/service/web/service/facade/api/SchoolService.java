package com.student.service.web.service.facade.api;

import com.student.service.web.model.School;

import java.util.List;

public interface SchoolService {

    School findById(Integer id);

    School findByName(String name);

    void saveSchool(School school);

    void updateSchool(School school);

    void deleteSchoolById(Integer id);

    void deleteAllSchools();

    List<School> findAllSchools();

    boolean isSchoolExist(School school);
}

