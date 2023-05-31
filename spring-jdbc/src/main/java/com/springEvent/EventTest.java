package com.springEvent;

import com.springEvent.controller.BookController;
import com.springEvent.controller.UserController;
import com.springEvent.entity.Book;
import com.springEvent.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class EventTest {

    @Autowired
    private UserController userController;

    @Autowired
    private BookController bookController;

    @Test
    public void buyBook() {
        // 购买数量
        int num = 2;

        User user = new User ("jacky", "man", 19, 500);
        Book book = new Book("test_book", 5, 49);

        user.setBalance(user.getBalance() - book.getPrice()*num);
        book.setCount(book.getCount() - num);

        // 需要两个控制器的方法完成购书事务
        userController.updateUserInfo(user);
        bookController.buyBook(book);
    }

    @Test
    public void controllerTest() {
        if (userController.register(new User("jack", "man", 18, 1000))) {
            System.out.println("user controller run");
        }
    }

}
