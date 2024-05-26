package com.example.demo.service;

public interface MovieService {
    MovieResponse getAllByTitle(String title, int page, int size);
}
