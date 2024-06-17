package com.example.demo.controllers;

import com.example.demo.models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @GetMapping("/all")
    public List<Person> getAll() {
        return people;
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Integer id) {
        return people.stream().filter(x->x.getId()==id).findFirst().orElseThrow();
    }
}
