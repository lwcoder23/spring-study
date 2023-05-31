package com.springEvent.dao;

import com.springEvent.entity.User;

import java.util.List;

public interface UserDao {

    boolean insert(User user);

    boolean update(User user);

    List<User> queryAll();

}
