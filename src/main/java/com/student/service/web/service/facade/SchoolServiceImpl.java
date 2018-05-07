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

    @Override
    public School findOne(Integer id) {
        return schoolRepository.findOne(id);
    }

    @Override
    public School findByName(String name) {
        return schoolRepository.findByName(name);
    }

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public void update(School school){
        save(school);
    }

    @Override
    public void deleteById(Integer id){
        schoolRepository.delete(id);
    }

    @Override
    public void deleteAll(){
        schoolRepository.deleteAll();
    }

    @Override
    public List<School> findAll(){
        return schoolRepository.findAll();
    }

}
