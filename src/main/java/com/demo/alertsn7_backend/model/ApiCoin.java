package com.demo.alertsn7_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ApiCoin {

    private Long id_apicoin;
    private String symbol;
    private Double current_price;

    public ApiCoin() {
    }

    public ApiCoin(Long id_apicoin, String symbol, Double current_price) {
        this.id_apicoin = id_apicoin;
        this.symbol = symbol;
        this.current_price = current_price;
    }
}
