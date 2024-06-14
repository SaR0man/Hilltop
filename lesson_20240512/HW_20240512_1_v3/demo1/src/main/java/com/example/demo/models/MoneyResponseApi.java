package com.example.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoneyResponseApi {
    private String now;  // текущая дата
    private String previousDate;
    private String previousURL;
    private String fullName;  // кто делает запрос
    private String baseUrl;  // адрес внешнего ресурса
    private int count;  // сколько монет?
    private Date timestamp;
    private List<Valuta> valute = new ArrayList<>();

 public MoneyResponseApi() {
 }

 public MoneyResponseApi(String now, Date previousDate, String previousURL, String fullName, String baseUrl ,int count, Date timestamp, List<Valuta> valute) {
  this.now = now;
  this.previousDate = String.valueOf(previousDate);
  this.previousURL = previousURL;
  this.fullName = fullName;
  this.baseUrl = baseUrl;
  this.count = count;
  this.timestamp = timestamp;
  this.valute = valute;
 }

 public String getNow() {
  return now;
 }

 public void setNow(String now) {
  this.now = now;
 }

 public String getPreviousDate() {
  return previousDate;
 }

 public void setPreviousDate(String previousDate) {
  this.previousDate = previousDate;
 }

 public String getPreviousURL() {
  return previousURL;
 }

 public void setPreviousURL(String previousURL) {
  this.previousURL = previousURL;
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


 public int getCount() {
  return count;
 }

 public void setCount(int count) {
  this.count = count;
 }

 public Date getTimestamp() {
  return timestamp;
 }

 public void setTimestamp(Date timestamp) {
  this.timestamp = timestamp;
 }

 public List<Valuta> getValute() {
  return valute;
 }

 public void setValute(List<Valuta> valute) {
  this.valute = valute;
 }
 public void addValute(Valuta val) {
  this.valute.add(val);
 }
}
