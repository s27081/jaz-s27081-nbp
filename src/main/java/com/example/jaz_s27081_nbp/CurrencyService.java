package com.example.jaz_s27081_nbp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class CurrencyService {

    private final String url = "http://api.nbp.pl/api/exchangerates/rates/A/{currencyId}/{startDate}/{endDate}";

    private final RestTemplate restTemplate;

    private final CurrecnyJpaRepository currecnyJpaRepository;


    public CurrencyService(RestTemplate restTemplate, CurrecnyJpaRepository currecnyJpaRepository) {
        this.restTemplate = restTemplate;
        this.currecnyJpaRepository = currecnyJpaRepository;
    }

    public CurrencyData calculateCurrency(String currencyId, LocalDate dateFrom, LocalDate dateTo) {
        Currency cur = restTemplate.getForObject(url, Currency.class, currencyId, dateFrom, dateTo);
        Double sum = 0.0;
        for(Rate rate : cur.getRates()) {
            sum += rate.getMid();
        }
        Double avgSum = sum/cur.getRates().size();
        CurrencyData db = new CurrencyData(cur.getCurrency(),dateFrom, dateTo,avgSum,LocalDate.now());
        addRecord(db);
        return db;

    }

    public void addRecord(CurrencyData db){
        currecnyJpaRepository.save(db);
    }

}
