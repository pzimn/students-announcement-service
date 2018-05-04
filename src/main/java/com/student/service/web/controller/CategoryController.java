package com.student.service.web.controller;

import com.student.service.web.model.Announcement;
import com.student.service.web.model.Category;
import com.student.service.web.repository.AnnouncementRepository;
import com.student.service.web.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    // Get All Categories
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
