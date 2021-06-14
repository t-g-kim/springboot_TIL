package com.module.server.webClient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import java.util.List;

public class Person {
    public int id;
    public String name;
    public int age;
    public String country;

    public Person() {
    }

    public Person(int id, String name, int age, String country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @JsonIgnore
    public Person getPerson(int id) {
        return personList.get(id);
    }

    @JsonIgnore
    public List<Person> getAllPeople() {
        return personList;
    }

    @JsonIgnore
    public Person addPerson(Person person) {
        personList.add(person);
        return person;
    }

    static List<Person> personList = Lists.newArrayList(
            new Person(0, "Jack", 29, "USA"),
            new Person(1, "John", 23, "Israel"),
            new Person(2, "Vladimir", 34, "Russia"),
            new Person(3, "Aarav", 39, "India"),
            new Person(4, "Chidi", 55, "Nigeria"),
            new Person(5, "Fleur", 30, "France")
    );

}
