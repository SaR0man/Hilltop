package com.example.demo.repositories;

import com.example.demo.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> getAll();
    Person getById(Integer id);

//    Optional<Object> findById(Long id);
}
