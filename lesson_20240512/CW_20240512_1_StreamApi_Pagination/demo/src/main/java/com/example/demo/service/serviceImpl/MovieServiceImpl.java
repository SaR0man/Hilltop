package com.example.demo.service.serviceImpl;

import com.example.demo.models.Movie;
import com.example.demo.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Override
    public List<Movie> getAllByTitle(String title) {
        return null;
    }
}
