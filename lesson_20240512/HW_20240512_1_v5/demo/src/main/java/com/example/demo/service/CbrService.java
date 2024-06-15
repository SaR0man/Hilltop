package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.models.CbrResponse;

import java.time.LocalDate;

@Service
public class CbrService {

    private final RestTemplate restTemplate;

    public CbrService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CbrResponse getCbrRates() {
        String url = "https://www.cbr-xml-daily.ru/daily_json.js";
        return restTemplate.getForObject(url, CbrResponse.class);
    }
}
