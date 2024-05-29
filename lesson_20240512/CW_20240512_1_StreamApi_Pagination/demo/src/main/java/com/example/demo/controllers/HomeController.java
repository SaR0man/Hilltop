package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    MovieService movieService;

    @GetMapping("/search")
    public List<Movie> test(String title) {
        return movieService.getAllByTitle(title);
    }
}
