package com.example.demo.repositories;

import com.example.demo.models.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> getAll();
    Person getById(Integer id);
}
