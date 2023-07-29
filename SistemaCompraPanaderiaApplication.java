package com.grupo3.sistemacomprapanaderia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class SistemaCompraPanaderiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaCompraPanaderiaApplication.class, args);
	}

}
