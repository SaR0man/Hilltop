package com.example.demo.models;

import java.util.Arrays;

public class Tools {

    public static MoneyResponseApi converterResponseToMoney(Response response){
        MoneyResponseApi moneyResponseApi = new MoneyResponseApi();
//        moneyResponseApi.setValute(Arrays.asList(getConverterValuteToValutaUSD(response.valute)));
        moneyResponseApi.addValute(getConverterValuteToValutaUsd(response.valute));
        moneyResponseApi.addValute(getConverterValuteToValutaEur(response.valute));
        moneyResponseApi.addValute(getConverterValuteToValutaAzn(response.valute));
        return  moneyResponseApi;
//        return null;
    }



    private static Valuta getConverterValuteToValutaUsd(Valute valute){
        Valuta valuta = new Valuta();
        valuta.id = valute.uSD.iD;
        valuta.name = valute.uSD.name;
        valuta.title = valute.uSD.charCode;
        valuta.value =valute.uSD.value;
        return valuta;
    }

    private static Valuta getConverterValuteToValutaEur(Valute valute){
        Valuta valuta = new Valuta();
        valuta.id = valute.eUR.iD;
        valuta.name = valute.eUR.name;
        valuta.title = valute.eUR.charCode;
        valuta.value =valute.eUR.value;
        return valuta;
    }

    private static Valuta getConverterValuteToValutaAzn(Valute valute){
        Valuta valuta = new Valuta();
        valuta.id = valute.aZN.iD;
        valuta.name = valute.aZN.name;
        valuta.title = valute.aZN.charCode;
        valuta.value =valute.aZN.value;
        return valuta;
    }
}
