package com.example.demo.controllers;

import com.example.demo.models.MoneyResponseApi;
import com.example.demo.models.Response;
import com.example.demo.models.Tools;
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
import java.util.Date;

@RestController
@RequestMapping("api/home")
public class HomeController {
    @GetMapping("test")
    public MoneyResponseApi test() {
        RestTemplate restTemplate = new RestTemplate();

        String baseUrl = "https://www.cbr-xml-daily.ru/daily_json.js";
        HttpHeaders httpHeaders = new HttpHeaders();  // org.springframework.http
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        var result = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, String.class);
        String resultJson = result.getBody();

        ObjectMapper objectMapper = new ObjectMapper();

//        Response response = new Response();
        MoneyResponseApi responseApi = null;

        try {
            Response response = objectMapper.readValue(resultJson, Response.class);
            responseApi = Tools.converterResponseToMoney(response);
            responseApi.setBaseUrl(baseUrl);
            responseApi.setFullName("Abdullayev Farid");
            responseApi.setPreviousURL("http://localhost:8080/api/home/test");
            responseApi.setCount(1);
            responseApi.setNow(new Date().toString());
            responseApi.setPreviousDate(new Date().toLocaleString());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return responseApi;
    }
}
