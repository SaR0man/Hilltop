package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.CbrService;
import com.example.demo.models.CbrResponse;
import com.example.demo.models.CbrResponseDto;

import java.time.LocalDate;

@RestController
public class CbrController {

    private final CbrService cbrService;

    @Autowired
    public CbrController(CbrService cbrService) {
        this.cbrService = cbrService;
    }

    @GetMapping("/cbr-rates")
    public CbrResponseDto getCbrRates() {
        CbrResponse cbrResponse = cbrService.getCbrRates();

        CbrResponseDto responseDto = new CbrResponseDto();
        responseDto.setNow(LocalDate.now().toString());
        responseDto.setFullName("Scrooge McDuck");
        responseDto.setBaseUrl("https://www.cbr-xml-daily.ru/daily_json.js");
        responseDto.setYourUrl("http://localhost:8080/api/home/valyuta");
        responseDto.setCount(cbrResponse.getValute().size());
        responseDto.setValute(cbrResponse.getValute());

        return responseDto;
    }
}