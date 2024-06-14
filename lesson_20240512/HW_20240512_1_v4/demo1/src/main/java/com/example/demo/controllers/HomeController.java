package com.example.demo.controllers;

import com.example.demo.models.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("api/home")
public class HomeController {
    @GetMapping("test")
    public Response test() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();  // org.springframework.http
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        var result = restTemplate.exchange("https://www.cbr-xml-daily.ru/daily_json.js", HttpMethod.GET, httpEntity, String.class);
        String resultJson = result.getBody();

        ObjectMapper objectMapper = new ObjectMapper();

        Response response = new Response();

        try {
            response = objectMapper.readValue(resultJson, Response.class);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return response;
    }
}
