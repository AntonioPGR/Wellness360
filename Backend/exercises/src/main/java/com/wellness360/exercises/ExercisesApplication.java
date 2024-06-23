package com.wellness360.exercises;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wellness360.exercises.packages.storage.services.StorageService;


@SpringBootApplication
public class ExercisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercisesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storage_service){
		return (args) -> {
			storage_service.init();
		};
	}

}
