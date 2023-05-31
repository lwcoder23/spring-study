package com.springEvent.controller;

import com.springEvent.entity.Book;
import com.springEvent.entity.User;
import com.springEvent.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    public void buyBook(Book book, User user) {
        bookService.buyBook(book, user);
    }

}
