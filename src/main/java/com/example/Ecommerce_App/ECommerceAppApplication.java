package com.example.Ecommerce_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.Ecommerce_App.repository.repository")
public class ECommerceAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(ECommerceAppApplication.class, args);

	}

}
