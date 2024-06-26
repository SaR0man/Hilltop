package com.example.demo.services;


import com.example.demo.models.Person;
import com.example.demo.repositories.impl.PersonRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonServices {

    private static  final Logger loger = LoggerFactory.getLogger(PersonServices.class);

    @Autowired
    PersonRepositoryImpl personRepository;

    public List<Person> getAll() {
        loger.info("List<Person> getAll() => " + LocalDateTime.now());
        return personRepository.getAll();
    }

    public Person getById(Integer id) {
        loger.info("Person getById(Integer id) => " + LocalDateTime.now());
        return personRepository.getById(id);
    }
}
