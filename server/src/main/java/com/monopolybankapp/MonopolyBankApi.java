package com.monopolybankapp;

import com.monopolybankapp.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class MonopolyBankApi {

	public static void main(String[] args) {
		SpringApplication.run(MonopolyBankApi.class, args);
	}

}
