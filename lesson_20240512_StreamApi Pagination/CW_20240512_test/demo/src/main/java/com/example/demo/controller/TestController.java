package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.model.ResponseMovieApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/test")
public class TestController {

    private final String apiKey = "2c9d65d5";
    private final String baseUrl = "https://www.omdbapi.com/";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/search2")
    public List<Movie> test(String title) {


        String url = baseUrl + "?apikey=" + apiKey + "&s=" + title + "&page=";

        System.out.println(url);
        ResponseEntity<ResponseMovieApi> response = restTemplate.getForEntity(url + 1, ResponseMovieApi.class);

        int totalResult = 0;
        List<Movie> arr = new ArrayList<>();

        if (response.getStatusCode().is2xxSuccessful()) {
            ResponseMovieApi result = response.getBody();

            totalResult = Integer.parseInt(result.totalResults);//97
            int page = (int) Math.ceil(totalResult / 10.0);
            System.out.println("Page  : " + page);
            System.out.println("Total : " + totalResult);

            for (int i = 0; i < result.Search.size(); i++) {
                arr.add(result.Search.get(i));
            }

            for (int i = 2; i <= page; i++) {
                System.out.println(url + i);
                System.out.println("Request => " + i);
                response = restTemplate.getForEntity(url + i, ResponseMovieApi.class);

                if (response.getStatusCode().is2xxSuccessful() && result != null && result.Search != null) {
                    result = response.getBody();

                    for (int j = 0; j < result.Search.size(); j++) {
                        arr.add(result.Search.get(j));
                    }
                }
            }
        }
        return arr;
    }
}