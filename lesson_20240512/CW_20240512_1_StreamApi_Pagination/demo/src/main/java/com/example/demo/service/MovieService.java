package com.example.demo.service;

import com.example.demo.models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllByTitle(String title);
}

