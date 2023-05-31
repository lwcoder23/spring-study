package com.springEvent.dao.impl;

import com.springEvent.dao.UserDao;
import com.springEvent.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insert(User user) {
        String sql = "insert into user_table(user_name, gender, age) values(?, ?, ?)";
        int i = jdbcTemplate.update(sql, user.getUserName(), user.getGender(), user.getAge());
        return i>0;
    }

    // temp function
    public boolean update(User user) {
        String sql = "update user_table set user_name = ?, gender = ?, age = ?, balance = ? where id = ?";
        int i = jdbcTemplate.update(sql, user.getId(), user.getUserName(), user.getGender(), user.getAge(), user.getBalance(), user.getId());
        return i>0;
    }

    public List<User> queryAll() {
        String sql = "select * from user_table";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>());
        return userList;
    }
}
