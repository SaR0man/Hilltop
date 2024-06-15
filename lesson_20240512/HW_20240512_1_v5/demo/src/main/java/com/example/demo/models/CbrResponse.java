package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CbrResponse {
    @JsonProperty("Date")
    private String date;

    @JsonProperty("Valute")
    private Map<String, Valute> valute;

    // getters and setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Valute> getValute() {
        return valute;
    }

    public void setValute(Map<String, Valute> valute) {
        this.valute = valute;
    }

    public static class Valute {
        @JsonProperty("ID")
        private String id;

        @JsonProperty("NumCode")
        private String numCode;

        @JsonProperty("CharCode")
        private String charCode;

        @JsonProperty("Nominal")
        private int nominal;

        @JsonProperty("Name")
        private String name;

        @JsonProperty("Value")
        private double value;

        @JsonProperty("Previous")
        private double previous;

        // getters and setters

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNumCode() {
            return numCode;
        }

        public void setNumCode(String numCode) {
            this.numCode = numCode;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String charCode) {
            this.charCode = charCode;
        }

        public int getNominal() {
            return nominal;
        }

        public void setNominal(int nominal) {
            this.nominal = nominal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public double getPrevious() {
            return previous;
        }

        public void setPrevious(double previous) {
            this.previous = previous;
        }
    }
}
