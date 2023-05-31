package com.springEvent.service;

import com.springEvent.entity.Book;
import com.springEvent.entity.User;

public interface BookService {

    boolean buyBook(Book book, User user);

}
