package com.demo.alertsn7_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Alertsn7BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Alertsn7BackendApplication.class, args);
	}

}
