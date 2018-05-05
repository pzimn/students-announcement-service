package com.student.service.web.repository;

import com.student.service.web.model.Category;
import com.student.service.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
