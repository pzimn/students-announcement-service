package com.student.service.web.repository;

import com.student.service.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String name);
    public User findByEmail(String email);
}
