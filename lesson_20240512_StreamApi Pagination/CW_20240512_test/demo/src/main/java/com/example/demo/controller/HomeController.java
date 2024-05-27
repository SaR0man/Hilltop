package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieResponse;
import com.example.demo.model.ResponseMovieApi;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    MovieService movieService;

    @GetMapping("/search")
    public MovieResponse test(
           @RequestParam(value = "title",required = true) String title,
           @RequestParam(value = "page",defaultValue = "1",required = false) int page,
           @RequestParam(value = "size",defaultValue = "10",required = false) int size
    ) {
        return movieService.getAllByTitle(title,page,size);
    }
}

