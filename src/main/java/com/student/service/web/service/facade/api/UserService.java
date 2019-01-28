package com.student.service.web.service.facade.api;

import com.student.service.web.model.User;

import java.util.List;

public interface UserService {

    User findOne(Integer id);

    User save(User user);

    void update(User user);

    void deleteById(Integer id);

    void deleteAll();

    List<User> findAll();

    public User findByUsername(String name);
    public User findByEmail(String email);
}