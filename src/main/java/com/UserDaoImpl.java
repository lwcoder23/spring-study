package com;

public class UserDaoImpl implements UserDao {

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void say() {
        System.out.println("run");
    }

}
