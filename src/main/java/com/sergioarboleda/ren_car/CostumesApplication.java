package com.sergioarboleda.costumes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {securityAutoConfiguration.class})
public class CostumesApplication {

	public static void main(String[] args) {

		SpringApplication.run(CostumesApplication.class, args);
	}

}
