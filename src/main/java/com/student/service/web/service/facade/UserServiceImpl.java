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

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void update(User user){
        save(user);
    }

    @Override
    public void deleteById(Integer id){
        userRepository.delete(id);
    }

    @Override
    public void deleteAll(){
        userRepository.deleteAll();
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

}
