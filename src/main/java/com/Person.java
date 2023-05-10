package com;

import java.util.List;

public class Person {

    Integer id;

    private List<User> userList;

    public Person() {
    }

    public Person(Integer id, List<User> userList) {
        this.id = id;
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
