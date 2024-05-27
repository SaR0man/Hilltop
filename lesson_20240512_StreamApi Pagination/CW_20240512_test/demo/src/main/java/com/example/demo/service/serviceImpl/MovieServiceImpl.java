package com.example.demo.service.serviceImpl;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieResponse;
import com.example.demo.model.ResponseMovieApi;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Value("${movie.api.key}")
    private String apiKey;
    @Value("${movie.url}")
    private String baseUrl;

    @Autowired
    RestTemplate restTemplate;

//    @Override
//    public MovieResponse getAllByTitle(String title, int page) {
//        String url = baseUrl + "?apikey=" + apiKey + "&s=" + title + "&page=";
//        ResponseEntity<ResponseMovieApi> response = restTemplate.getForEntity(url + page, ResponseMovieApi.class);
//        MovieResponse movieResponse = new MovieResponse();
//
//        if (response.getStatusCode().is2xxSuccessful()) {
//            List<Movie> arr = new ArrayList<>();
//            ResponseMovieApi result = response.getBody();
//
//            for (int i = 0; i < result.Search.size(); i++) {
//                arr.add(result.Search.get(i));
//            }
//            int totalResult = Integer.parseInt(result.totalResults);//97
//            int pages = (int) Math.ceil(totalResult / 10.0);
//
//            movieResponse.setMovies(arr);
//            movieResponse.setCurrentPage(page);
//            movieResponse.setPages(pages);
//        }
//
//        return movieResponse;
//    }


    @Override
    public MovieResponse getAllByTitle(String title, int page, int size) {
        String url = baseUrl + "?apikey=" + apiKey + "&s=" + title + "&page=";
        ResponseEntity<ResponseMovieApi> response = restTemplate.getForEntity(url + 1, ResponseMovieApi.class);
        MovieResponse movieResponse = new MovieResponse();

        if (response.getStatusCode().is2xxSuccessful()) {
            List<Movie> arr = new ArrayList<>();
            ResponseMovieApi result = response.getBody();

            for (int i = 0; i < result.Search.size(); i++) {
                arr.add(result.Search.get(i));
            }

            int totalResult = Integer.parseInt(result.totalResults);//97
                int mSize = (int) Math.ceil(totalResult / 10.0);
            for (int i = 2; i <= mSize; i++) {
                System.out.println(url + i);
                System.out.println("Request => " + i);
                response = restTemplate.getForEntity(url + i, ResponseMovieApi.class);

                if (response.getStatusCode().is2xxSuccessful() && result != null && result.Search != null) {
                    result = response.getBody();

                    for (int j = 0; j < result.Search.size(); j++) {
//                        System.out.println(result.Search.get(j));
                        arr.add(result.Search.get(j));
                    }
                }
            }

//                int pages = (int) Math.ceil(totalResult / 10.0);
            int totalPages = (int) Math.ceil(totalResult / (double) size);

//            List<Movie> tmp = new ArrayList<>();
//            for (int i = size*page-size;i<arr.size() && i < size*page ; i++) {
//                tmp.add(arr.get(i));
//            }

            arr = arr.stream().skip(size*page-size).limit(size).collect(Collectors.toList());

            movieResponse.setMovies(arr);
            movieResponse.setCurrentPage(page);
            movieResponse.setPages(totalPages);
        }

        return movieResponse;
    }
}


//    String url = baseUrl + "?apikey=" + apiKey + "&s=" + title + "&page=";
//
//        System.out.println(url);
//                ResponseEntity<ResponseMovieApi> response = restTemplate.getForEntity(url + 1, ResponseMovieApi.class);
//
//        int totalResult = 0;
//        List<Movie> arr = new ArrayList<>();
//
//        if (response.getStatusCode().is2xxSuccessful()) {
//        ResponseMovieApi result = response.getBody();
//
//        totalResult = Integer.parseInt(result.totalResults);//97
//        int page = (int) Math.ceil(totalResult / 10.0);
//        System.out.println("Page  : " + page);
//        System.out.println("Total : " + totalResult);
//
//        for (int i = 0; i < result.Search.size(); i++) {
//        arr.add(result.Search.get(i));
//        }
//
//        for (int i = 2; i <= page; i++) {
//        System.out.println(url + i);
//        System.out.println("Request => " + i);
//        response = restTemplate.getForEntity(url + i, ResponseMovieApi.class);
//
//        if (response.getStatusCode().is2xxSuccessful() && result != null && result.Search != null) {
//        result = response.getBody();
//
//        for (int j = 0; j < result.Search.size(); j++) {
////                        System.out.println(result.Search.get(j));
//        arr.add(result.Search.get(j));
//        }
//        }
//        }
//        }