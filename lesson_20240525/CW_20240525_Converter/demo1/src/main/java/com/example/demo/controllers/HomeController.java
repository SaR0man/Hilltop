package com.example.demo.controllers;

import com.example.demo.models.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.*;

import java.util.*;

@RestController
@RequestMapping("api/home")
public class HomeController {


    @GetMapping("test")
    public List<Valuta> test() {
        RestTemplate restTemplate = new RestTemplate();

        String baseUrl = "https://www.cbr-xml-daily.ru/daily_json.js";
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity httpEntity = new HttpEntity(httpHeaders);
//        var result = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, String.class);
        var resultJson = restTemplate.getForObject(baseUrl, String.class);
        JSONObject jsonObject = new JSONObject(resultJson);
        JSONObject value = jsonObject.getJSONObject("Valute");


        List<Valuta> valuteList = new ArrayList<>();


        value.keys().forEachRemaining(key -> {
            JSONObject val = value.getJSONObject(key);
            if (key.equals("CHF")||key.equals("USD")||key.equals("AZN"))
                valuteList.add(new Valuta(
                        val.getString("ID"),
                        val.getString("CharCode"),
                        val.getDouble("Value"),
                        val.getString("Name")

                ));
        });


        return valuteList;
    }


//
//    @GetMapping("test")
//    public MoneyResponseApi test() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String baseUrl = "https://www.cbr-xml-daily.ru/daily_json.js";
//        HttpHeaders httpHeaders = new HttpHeaders();
////        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
////        HttpEntity httpEntity = new HttpEntity(httpHeaders);
////        var result = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, String.class);
//        var result = restTemplate.getForObject(baseUrl, String.class);
//        String resultJson = result;
//        ObjectMapper objectMapper = new ObjectMapper();
//        MoneyResponseApi responseApi = null;
//        try {
//            Response  response = objectMapper.readValue(resultJson, Response.class);
//            responseApi = Tools.converterResponseToMoney(response);
//            responseApi.setBaseUrl(baseUrl);
//            responseApi.setFullName("Abdullayev Farid");
//            responseApi.setPreviousURL("http://localhost:8080/api/home/test");
//            responseApi.setCount(1);
//            responseApi.setNow(new Date().toString());
//            responseApi.setPreviousDate(new Date().toLocaleString());
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            System.out.println(ex.getMessage());
//            System.out.println(ex.getMessage());
//        }
//        return responseApi;
//    }


//    @GetMapping("test")
//    public Response test() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String baseUrl = "https://www.cbr-xml-daily.ru/daily_json.js";
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity httpEntity = new HttpEntity(httpHeaders);
//
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        messageConverters.add(converter);
//        restTemplate.setMessageConverters(messageConverters);
//
//        var result = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Response.class);
//        return result.getBody();
////        String resultJson = result;
////        ObjectMapper objectMapper = new ObjectMapper();
////        MoneyResponseApi responseApi = null;
////        try {
////            Response  response = objectMapper.readValue(resultJson, Response.class);
////            return response;
////        } catch (Exception ex) {
////            System.out.println(ex.getMessage());
////            System.out.println(ex.getMessage());
////            System.out.println(ex.getMessage());
////        }
////        return null;
//    }
}