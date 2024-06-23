package com.example.demo.repositories.impl;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private List<Person> people;

    //// Сымитируем ситуацию, как будто мы обратились в БД и получили из нее ответ:
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
    //// ... конец имитации

    @Override
    public List<Person> getAll() {
        return people;
    }

    @Override
    public Person getById(Integer id) {
        return people.stream().filter(x->x.getId()==id).findFirst().orElse(null);
    }
}
