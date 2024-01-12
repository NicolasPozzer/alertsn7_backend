package com.demo.alertsn7_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class BotService implements IBotService {

    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot";

    @Value("${telegram.bot.token}") // Inyecta el token desde el application.properties
    private String botToken;

    private final RestTemplate restTemplate;

    public BotService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        String apiUrl = TELEGRAM_API_URL + botToken;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String sendMessageUrl = String.format("%s/sendMessage?chat_id=%s&text=%s", apiUrl, chatId, encodeURIComponent(message));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            String response = restTemplate.postForObject(sendMessageUrl, entity, String.class);
            System.out.println("Mensaje enviado: " + response);
        } catch (Exception e) {
            System.err.println("Error al enviar el mensaje: " + e.getMessage());
        }
    }

    private String encodeURIComponent(String value) {
        // Tu implementación para codificar el valor, si es necesario
        return value;
    }
}
