package com.example.demo.services;


import com.example.demo.models.Person;
import com.example.demo.repositories.impl.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepositoryImpl personRepository;

    public List<Person> getAll() {
        return personRepository.getAll();
    }

    public Person getById(Integer id) {
        return personRepository.getById(id);
    }
}
