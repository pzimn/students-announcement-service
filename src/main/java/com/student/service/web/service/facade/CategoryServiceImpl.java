package com.student.service.web.service.facade;

import com.student.service.web.model.Category;
import com.student.service.web.repository.CategoryRepository;
import com.student.service.web.service.facade.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        saveCategory(category);
    }

    public void deleteCategoryById(Integer id){
        categoryRepository.delete(id);
    }

    public void deleteAllCategories(){
        categoryRepository.deleteAll();
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public boolean isCategoryExist(Category category) {
        //return findByName(category.getName()) != null;
        return false; //todo
    }
}
