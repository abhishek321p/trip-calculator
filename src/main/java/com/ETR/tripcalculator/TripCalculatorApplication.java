package com.ETR.tripcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TripCalculatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(TripCalculatorApplication.class, args);
	}
}
