package com.student.service.web.service.facade;

import com.student.service.web.model.User;
import com.student.service.web.repository.UserRepository;
import com.student.service.web.service.facade.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user){
        saveUser(user);
    }

    public void deleteUserById(Integer id){
        userRepository.delete(id);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }
}
