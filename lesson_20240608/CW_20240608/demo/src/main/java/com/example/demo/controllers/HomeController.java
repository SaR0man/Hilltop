package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.HistoryServices;
import com.example.demo.services.PersonServices;
import com.example.demo.utils.CommonUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    PersonServices personServices;

    @Autowired
    HistoryServices historyServices;

    @GetMapping("/all")
    public List<Person> getAll(HttpServletRequest request) throws Exception {
        logger.info("/all => " + CommonUtil.getIp(request) + " : " + LocalDateTime.now());
        if (!historyServices.addIp(CommonUtil.getIp(request))) {
            return null;
        }
        return personServices.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(HttpServletRequest request, @PathVariable Integer id) {
        logger.info("/id (" + id + ") => " + CommonUtil.getIp(request) + " : " + LocalDateTime.now());
        historyServices.addIp(CommonUtil.getIp(request));
        return personServices.getById(id);
    }

    @GetMapping("/info")
    public Map info() {
        return (Map) historyServices.getInfo();
    }
}
