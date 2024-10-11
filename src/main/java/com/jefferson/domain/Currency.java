package com.jefferson.domain;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Currency {

    @SerializedName("conversion_rates")
    private Map<String, Double> currencys;

    public Currency() {
    }
    public Currency(Map<String, Double> currencys) {
        this.currencys = currencys;
    }

    public Map<String, Double> getCurrencys() {
        return currencys;
    }

    public void setCurrencys(Map<String, Double> currencys) {
        this.currencys = currencys;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencys=" + currencys +
                '}';
    }
}
