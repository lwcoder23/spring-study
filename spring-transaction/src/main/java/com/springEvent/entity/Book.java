package com.springEvent.entity;

import org.springframework.stereotype.Component;

@Component
public class Book {

    private int id;

    private String bookName;

    // 书的库存
    private int count;

    private int price;

    public Book() {}

    public Book(String bookName, int count, int price) {
        this.bookName = bookName;
        this.count = count;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
