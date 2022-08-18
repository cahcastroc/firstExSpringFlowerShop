package com.sicredi.exercicio2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.sicredi.exercicio2.model")
@EnableJpaRepositories(basePackages = "com.sicredi.exercicio2.repositories")
@ComponentScan(basePackages = {"com.sicredi.exercicio2.controllers","com.sicredi.exercicio2.exceptions","com.sicredi.exercicio2.services"})

public class Exercicio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercicio2Application.class, args);
	}

}
