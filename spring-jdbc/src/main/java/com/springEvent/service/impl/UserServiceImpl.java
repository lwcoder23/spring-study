package com.springEvent.service.impl;

import com.springEvent.dao.impl.UserDaoImpl;
import com.springEvent.entity.User;
import com.springEvent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    public List<User> upload() {
        return userDao.queryAll();
    }

    public boolean register(User user) {
        return userDao.insert(user);
    }

    public boolean updateUser(User user) {
        return userDao.update(user);
    }
}
