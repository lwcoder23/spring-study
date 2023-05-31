package com.springEvent.controller;

import com.springEvent.entity.User;
import com.springEvent.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    public void updateUserInfo(User user) {
        userService.updateUser(user);
    }

    public boolean register(User user) {
        return userService.register(user);
    }

}
