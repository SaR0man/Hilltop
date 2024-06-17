package com.example.demo.repositories.impl;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(1, "James", "Smith", 28));
        people.add(new Person(2, "Michael", "Johnson", 27));
        people.add(new Person(3, "Robert", "Williams", 35));
        people.add(new Person(4, "John", "Brown", 37));
        people.add(new Person(5, "Linda", "Smith", 25));
        people.add(new Person(6, "Patricia", "Brown", 29));
        people.add(new Person(7, "Susan", "Jones", 32));
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public Person getById(Integer id) {
        return null;
    }
}
