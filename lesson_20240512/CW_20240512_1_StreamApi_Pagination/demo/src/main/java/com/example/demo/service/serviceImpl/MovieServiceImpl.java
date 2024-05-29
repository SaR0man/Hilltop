package com.example.demo.service.serviceImpl;

import com.example.demo.models.Movie;
import com.example.demo.models.ResponseMovieApi;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Value("${movie.url}")
    private String baseUrl;

    @Value("${movie.api.key}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Movie> getAllByTitle(String title) {

        String url = baseUrl + "?apikey=" + apiKey + "&s=" + title + "&page=";

        System.out.println(url);
        ResponseEntity<ResponseMovieApi> response = restTemplate.getForEntity(url + 1, ResponseMovieApi.class);

        List<Movie> arr = new ArrayList<>();

        if (response.getStatusCode().is2xxSuccessful()) {
            ResponseMovieApi result = response.getBody();

            // цикл для первой страницы
            for (int i = 0; i < result.Search.size(); i++) {
                System.out.println(result.Search.get(i).getTitle());
                arr.add(result.Search.get(i));
            }
        }

        return arr;
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
//        // цикл для первой страницы
//        for (int i = 0; i < result.Search.size(); i++) {
//        System.out.println(result.Search.get(i).getTitle());
//        arr.add(result.Search.get(i));
//        }
//
//        // цикл для последующих страниц
//        for (int i = 2; i <= page; i++) {
//        System.out.println("Request => " + i);
//        response = restTemplate.getForEntity(url + i, ResponseMovieApi.class);
//
//        if (response.getStatusCode().is2xxSuccessful() && result != null && result.Search != null) {
//        result = response.getBody();
//
//
//        for (int j = 0; j < result.Search.size(); j++) {
//        System.out.println(result.Search.get(j).getTitle());
//        arr.add(result.Search.get(j));
//        }
//        }
//        }
//        }