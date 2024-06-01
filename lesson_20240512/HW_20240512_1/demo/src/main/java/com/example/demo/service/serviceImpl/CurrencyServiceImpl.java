package com.example.demo.service.serviceImpl;

import com.example.demo.models.Currency;
import com.example.demo.models.CurrencyResponse;
import com.example.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CurrencyResponse getAllCurrencies() {
        String url = "https://www.cbr-xml-daily.ru/daily_json.js";

        CurrencyResponse response = restTemplate.getForObject(url, CurrencyResponse.class);
        return response;
    }
}
