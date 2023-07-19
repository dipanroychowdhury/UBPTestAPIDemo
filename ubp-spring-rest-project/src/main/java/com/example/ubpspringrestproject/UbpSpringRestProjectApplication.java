package com.example.ubpspringrestproject;

import com.example.controller.CalculateSDController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UbpSpringRestProjectApplication {

	private static CalculateSDController calculateSDController;

	public static void main(String[] args) {

		SpringApplication.run(UbpSpringRestProjectApplication.class, args);

	}

}
