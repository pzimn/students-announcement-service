package com.student.service.web.service.facade.api;

import com.student.service.web.model.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Integer id);

    Category findByName(String name);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(Integer id);

    void deleteAllCategories();

    List<Category> findAllCategories();

    boolean isCategoryExist(Category category);
}