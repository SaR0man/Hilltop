package com.example.demo.models;

import java.util.List;

public class MovieResponse {
    private int currentPage;
    private int pages;
    private List<Movie> movies;

    public MovieResponse() {
    }

    public MovieResponse(int currentPage, int pages, List<Movie> movies) {
        this.currentPage = currentPage;
        this.pages = pages;
        this.movies = movies;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
