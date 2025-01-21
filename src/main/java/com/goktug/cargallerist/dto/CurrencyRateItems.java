package com.goktug.cargallerist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyRateItems {

    @JsonProperty("Tarih")
    private String date;

    @JsonProperty("TP_DK_USD_A")
    private String usd;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }
}
