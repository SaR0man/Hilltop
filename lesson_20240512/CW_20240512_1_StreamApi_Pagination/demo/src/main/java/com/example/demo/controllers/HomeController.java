package com.example.demo.controllers;

import com.example.demo.models.MovieResponse;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    MovieService movieService;

    @GetMapping("/search")
    public MovieResponse test(
            @RequestParam(value = "title", required = true) String title,
            @RequestParam(value = "page", defaultValue = "1", required = false) int page
    ) {
        System.out.println(page);
        return movieService.getAllByTitle(title, page);
    }
}
