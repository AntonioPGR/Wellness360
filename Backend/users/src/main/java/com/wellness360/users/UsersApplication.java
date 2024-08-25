package com.wellness360.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wellness360.users.packages.storage.StorageService;
import com.wellness360.users.settings.storage.StorageFolders;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService service){
		return (args) -> {
			service.init(StorageFolders.class);
		};
	}

}
