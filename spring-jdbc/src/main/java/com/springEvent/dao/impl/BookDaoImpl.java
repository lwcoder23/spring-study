package com.springEvent.dao.impl;

import com.springEvent.dao.BookDao;
import com.springEvent.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean update(Book book) {
        String sql = "update book_table set book_name = ?, count = ?, price = ? where id = ?";
        int i = jdbcTemplate.update(sql, book.getBookName(), book.getCount(), book.getPrice(), book.getId());
        return i>0;
    }
}
