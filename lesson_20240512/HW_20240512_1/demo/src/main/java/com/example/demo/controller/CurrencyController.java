package com.example.demo.controllers;

import com.example.demo.models.CurrencyResponse;
import com.example.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/all")
    public CurrencyResponse getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }
}
