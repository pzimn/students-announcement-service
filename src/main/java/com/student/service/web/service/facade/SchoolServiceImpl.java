package com.student.service.web.service.facade;

import com.student.service.web.model.School;
import com.student.service.web.repository.SchoolRepository;
import com.student.service.web.service.facade.api.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("schoolService")
@Transactional
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public School findById(Integer id) {
        return schoolRepository.findOne(id);
    }

    public School findByName(String name) {
        return schoolRepository.findByName(name);
    }

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public void updateSchool(School school){
        saveSchool(school);
    }

    public void deleteSchoolById(Integer id){
        schoolRepository.delete(id);
    }

    public void deleteAllSchools(){
        schoolRepository.deleteAll();
    }

    public List<School> findAllSchools(){
        return schoolRepository.findAll();
    }

    public boolean isSchoolExist(School school) {
        return findByName(school.getName()) != null;
    }
}
