package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final String apiKey = "5c3f2d56";
    private final String baseUrl = "https://www.omdbapi.com/";

    @GetMapping("/search")
    public void test(String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "?apikey=" + apiKey + "&s=" + title;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getBody().containsKey("Search")) {
            ArrayList<Map<String, String>> search = (ArrayList<Map<String, String>>) response.getBody().get("Search");

            search.forEach(x -> {
                System.out.println(x.get("Title"));
            });
        }
    }
}
