package com.example.jaz_s27081_nbp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "`nbp`")
public class CurrencyData {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Schema(description = "Currency search ID")
    private Integer id;

    @Schema(description = "Currency name")
    private String name;
    @Schema(description = "Starting date")
    private LocalDate fromDate;

    @Schema(description = "Ending date")
    private LocalDate toDate;

    @Schema(description = "Average price between formDate and toDate")
    private Double price;

    @Schema(description = "Date when request was created")
    private LocalDate reqDate;


    public CurrencyData(String name, LocalDate fromDate, LocalDate toDate, Double price, LocalDate reqDate) {
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
        this.reqDate = reqDate;
    }

    public CurrencyData() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReqDate() {
        return reqDate;
    }

    public void setReqDate(LocalDate reqDate) {
        this.reqDate = reqDate;
    }
}
