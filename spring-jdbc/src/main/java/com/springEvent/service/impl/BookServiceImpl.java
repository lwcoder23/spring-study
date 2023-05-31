package com.springEvent.service.impl;

import com.springEvent.dao.impl.BookDaoImpl;
import com.springEvent.dao.impl.UserDaoImpl;
import com.springEvent.entity.Book;
import com.springEvent.entity.User;
import com.springEvent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private UserDaoImpl userDao;

    // 事务的各种属性，详见笔记
    @Transactional(timeout = 3, noRollbackFor = ArithmeticException.class, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)  // 3s
    //@Transactional(noRollbackForClassName = "java.lang.ArithmeticException")
    public boolean buyBook(Book book, User user) {
        // 事务的必要性：若这一系列操作中的某一个环节出错，则此环节之前的操作已经完成无法撤回，但 buyBook 操作却是失败的 -> 事务的原子性
        // example：扣钱了，但是图书库存不足无法购买
        return bookDao.update(book) && userDao.update(user);
    }
}
