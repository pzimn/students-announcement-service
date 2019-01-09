package com.student.service.web.service.facade.api;

import com.student.service.web.model.Category;

import java.util.List;

public interface CategoryService {

    Category findOne(Integer id);

    Category findByName(String name);

    Category save(Category category);

    void update(Category category);

    void deleteById(Integer id);

    void deleteAll();

    List<Category> findAll();

}