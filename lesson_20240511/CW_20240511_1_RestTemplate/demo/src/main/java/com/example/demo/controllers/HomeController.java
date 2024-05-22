package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final String apiKey = "2c9d65d5";
    private final String baseUrl = "https://www.omdbapi.com/";

    @GetMapping("/search")
    public void test(String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "?apikey=" + apiKey + "&s=" + title;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.println(HttpStatus.NOT_FOUND.getReasonPhrase());
        System.out.println(HttpStatus.NOT_FOUND.value());

        if (response.getStatusCode().is2xxSuccessful()) {
            if (response.hasBody())
                System.out.println("Response status code : " + response.getBody());
            else {
                System.out.println("Response not exist body");
            }
        }
    }
}
