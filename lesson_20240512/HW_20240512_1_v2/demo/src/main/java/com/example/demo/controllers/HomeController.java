package com.example.demo.controllers;

import com.example.demo.models.ValuteResponse;
import com.example.demo.service.ValuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    ValuteService valuteService;

    @GetMapping("/query")
    public ValuteResponse test() {
        return valuteService.getAll();
    }
}
