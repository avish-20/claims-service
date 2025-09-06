package com.insurance.claim_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.insurance.claim_service.repository.UserRepository;

@SpringBootApplication
public class ClaimServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDbConnection(UserRepository userRepository) {
		return args -> {
			try {
				long userCount = userRepository.count();
				System.out.println("==========================================================");
				System.out.println("✅ DATABASE CONNECTION SUCCESSFUL!");
				System.out.println("Found " + userCount + " users in the 'users' table.");
				System.out.println("==========================================================");
			} catch (Exception e) {
				System.err.println("==========================================================");
				System.err.println("❌ DATABASE CONNECTION FAILED!");
				System.err.println("Error: " + e.getMessage());
				System.err.println("==========================================================");
			}
		};
	}

}
