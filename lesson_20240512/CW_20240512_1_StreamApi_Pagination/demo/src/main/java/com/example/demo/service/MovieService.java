package com.example.demo.service;

import com.example.demo.models.MovieResponse;

public interface MovieService {
    MovieResponse getAllByTitle(String title, int page, int size);
}

