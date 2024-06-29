package com.example.jaz_s27081_nbp;

import java.util.List;

public class Currency {
    private String currency;
    private List<Rate> rates;

    public Currency() {

    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
