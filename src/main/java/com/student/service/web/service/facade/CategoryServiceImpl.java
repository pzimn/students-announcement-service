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

    public Category findOne(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void update(Category category){
        save(category);
    }

    @Override
    public void deleteById(Integer id){
        categoryRepository.delete(id);
    }

    @Override
    public void deleteAll(){
        categoryRepository.deleteAll();
    }

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

}
