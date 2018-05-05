package com.student.service.web.controller;

import com.student.service.web.model.Announcement;
import com.student.service.web.model.Category;
import com.student.service.web.repository.AnnouncementRepository;
import com.student.service.web.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    CategoryRepository categoryRepository;

    // Get All Categories
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Create a new Category
    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        logger.info("Saving category: {}. ", category);
        return categoryRepository.save(category);
    }

    // Get a Single Category
    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Integer categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        logger.info("Retrieved user from DB: {}. ",category);
        return category;
    }

    // Update a Category
    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category category) {
        logger.info("Updating category in DB: {}. ", category);
        categoryRepository.save(category);
        logger.info("Updated category in DB: {}. ", category);
        return category;
    }

    // Delete a Category
    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable("id") Integer categoryId) {
        logger.info("Deleting category from DB with ID: {}. ", categoryId);
        categoryRepository.delete(categoryId);
    }

}
