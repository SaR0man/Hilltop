package com.example.demo.service.serviveImpl;

import com.example.demo.models.ValuteResponse;
import com.example.demo.service.ValuteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValuteServiceImpl implements ValuteService {

    @Value("${valute.url}")
    private String baseUrl;

    @Value("${valute.converter}")
    private String mainQuery;

    @Override
    public ValuteResponse getAll() {

        String url = baseUrl + mainQuery;



        return null;
    }
}
