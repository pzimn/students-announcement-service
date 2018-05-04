package com.student.service.web.repository;

import com.student.service.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long userId);
    //List<User> findByName(String Name);
}
