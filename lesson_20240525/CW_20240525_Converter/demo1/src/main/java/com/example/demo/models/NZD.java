package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

 class NZD {
    @JsonProperty("ID")
     String iD;
    @JsonProperty("NumCode")
     String numCode;
    @JsonProperty("CharCode")
     String charCode;
    @JsonProperty("Nominal")
     int nominal;
    @JsonProperty("Name")
     String name;
    @JsonProperty("Value")
     double value;
    @JsonProperty("Previous")
     double previous;
}
