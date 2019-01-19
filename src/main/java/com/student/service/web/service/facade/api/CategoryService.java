package com.student.service.web.service.facade.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.service.web.model.Category;

public interface CategoryService extends JpaRepository<Category, Integer>{

    Category findByName(String name);

    void deleteById(Integer id);


}