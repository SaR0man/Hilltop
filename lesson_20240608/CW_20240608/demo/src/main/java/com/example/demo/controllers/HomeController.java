package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    PersonServices personServices;

    @GetMapping("/all")
    public List<Person> getAll() {
        return personServices.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Integer id) {
        return personServices.getById(id);
    }
}
