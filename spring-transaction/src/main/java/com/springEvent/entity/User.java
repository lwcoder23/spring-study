package com.springEvent.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

    private int id;

    private String userName;

    private String gender;

    private int age;

    private int balance;

    public User() {}

    public User(String name, String gender, int age, int balance) {
        this.userName = name;
        this.gender = gender;
        this.age = age;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
