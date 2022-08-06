package com.example.coindesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CoindeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoindeskApplication.class, args);
	}

}
