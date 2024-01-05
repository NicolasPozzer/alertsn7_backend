package com.demo.alertsn7_backend.service;

import com.demo.alertsn7_backend.model.ApiCoin;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiCoinService implements IApiCoinService{

    private static final String API_URL = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";

    @Override
    public List<ApiCoin> listadoApiCoin() {
        try {
            // Crear una instancia de RestTemplate
            RestTemplate restTemplate = new RestTemplate();

            // Realizar la solicitud HTTP y deserializar la respuesta automáticamente a una lista de ApiCoin
            ApiCoin[] apiCoinsArray = restTemplate.getForObject(API_URL, ApiCoin[].class);

            // Convertir el array a lista
            List<ApiCoin> apiCoinList = Arrays.asList(apiCoinsArray);

            return apiCoinList;
        } catch (Exception e) {
            // Manejar errores, lanzar excepciones o devolver una lista vacía según tus necesidades.
            e.printStackTrace();
            return null;
        }
    }
}
