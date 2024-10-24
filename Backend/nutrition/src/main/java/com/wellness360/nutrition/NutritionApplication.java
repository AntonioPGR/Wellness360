package com.wellness360.nutrition;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.wellness360.nutrition.packages.storage.StorageService;
import com.wellness360.nutrition.settings.storage.StorageFolders;

@SpringBootApplication
public class NutritionApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storage_service){
		return (args) -> {
			storage_service.init(StorageFolders.class);
		};
	}
}
