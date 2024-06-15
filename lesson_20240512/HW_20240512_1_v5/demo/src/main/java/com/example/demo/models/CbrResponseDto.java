package com.example.demo.models;

import java.util.Map;

public class CbrResponseDto {
    private String now;
    private String fullName;
    private String baseUrl;
    private String yourUrl;
    private int count;
    private Map<String, CbrResponse.Valute> valute;

    // Getters and setters

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getYourUrl() {
        return yourUrl;
    }

    public void setYourUrl(String yourUrl) {
        this.yourUrl = yourUrl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<String, CbrResponse.Valute> getValute() {
        return valute;
    }

    public void setValute(Map<String, CbrResponse.Valute> valute) {
        this.valute = valute;
    }
}
