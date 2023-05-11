package factoryBean;

import com.Person;

public class User {

    public User() {
        System.out.println("null construct");
    }

    public User(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    private String name;

    private Person person;

    private String[] loves;
    
    public void say() {
        System.out.println("function already");
    }
}

