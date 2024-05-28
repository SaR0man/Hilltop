package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("imdbID")
    private String imdbID;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Poster")
    private String poster;
    public String getTitle() {
        return this.title; }
    public void setTitle(String title) {
        this.title = title; }
    public String getYear() {
        return this.year; }
    public void setYear(String year) {
        this.year = year; }
    public String getImdbID() {
        return this.imdbID; }
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID; }
    public String getType() {
        return this.type; }
    public void setType(String type) {
        this.type = type; }
    public String getPoster() {
        return this.poster; }
    public void setPoster(String poster) {
        this.poster = poster; }
}
