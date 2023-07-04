package com.ition.bitcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ition.bitcoin")
public class ItionAssignment {
	public static void main(String[] args) {
		SpringApplication.run(ItionAssignment.class, args);

	}
}
