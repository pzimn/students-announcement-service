package com.student.service.web.controller;

import com.student.service.web.model.User;
import com.student.service.web.repository.UserRepository;
import org.springframework.stereotype.Controller;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = Logger.getLogger(User.class);

    /***
     * @Autowired
     * private UserService userService;
     */

    @RequestMapping(value = "/")
    public String index(){
        return "Greetings!";
    }

}
