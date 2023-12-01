package com.vivafattura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VivafatturaLoginClienteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VivafatturaLoginClienteServiceApplication.class, args);
	}

}
