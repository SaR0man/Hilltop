package com.example.demo.service;

import com.example.demo.models.MovieResponse;

import java.util.List;

public interface MovieService {
    MovieResponse getAllByTitle(String title, int page);
}

