package com.student.service.web.service.facade.api;

import com.student.service.web.model.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);

    void deleteAll();

    List<User> findAll();

    boolean isUserExist(User user);
}