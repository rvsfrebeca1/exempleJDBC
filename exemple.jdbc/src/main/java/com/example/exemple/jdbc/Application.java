package com.example.exemple.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(excludeName = "com.example.exemple.jdbc.configuration")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
