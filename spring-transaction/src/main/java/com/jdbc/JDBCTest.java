package com.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private User user;

    @Test
    public void jdbc() {
        // add
        String sql = "insert into test_table values(null,?,?,?)";
        int result = jdbcTemplate.update(sql, "张三", 21, "男");
    }

    @Test
    public void selectOne() {
        String sql = "select * from test_table where id = ?";
        /*User queryResult = jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> {
                    User userTemp = new User();
                    userTemp.setId(rs.getInt("id"));
                    userTemp.setName(rs.getString("name"));
                    userTemp.setAge(rs.getInt("age"));
                    userTemp.setGender(rs.getString("gender"));
                    return userTemp;
                }, 1);*/

        User queryResult = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(/*User.class*/), 1);
    }

    @Test
    public void selectAll() {
        String sql = "select * from test_table";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>());
    }

    @Test
    public void selectField() {
        String sql = "select count(id) from test_table";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
