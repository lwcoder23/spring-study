package com.springEvent.service;

import com.springEvent.entity.User;

import java.util.List;

public interface UserService {

    List<User> upload();

    boolean register(User user);

    boolean updateUser(User user);

}