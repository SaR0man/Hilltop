package com.example.demo.models;

public class Valuta {
    String id;
    String name;
    Double value;
    String title;

    public Valuta() {
    }

    public Valuta(String id, String name, Double value, String title) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}