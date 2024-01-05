package com.demo.alertsn7_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ApiCoin {

    private Long id_apicoin;
    private String baseAsset;
    private Double lastPrice;

    public ApiCoin() {
    }

    public ApiCoin(Long id_apicoin, String baseAsset, Double lastPrice) {
        this.id_apicoin = id_apicoin;
        this.baseAsset = baseAsset;
        this.lastPrice = lastPrice;
    }
}
