package com.demo.alertsn7_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ApiCoin {

    private String symbol;
    private Double current_price;

    public ApiCoin() {
    }

    public ApiCoin(String symbol, Double current_price) {
        this.symbol = symbol;
        this.current_price = current_price;
    }
}
