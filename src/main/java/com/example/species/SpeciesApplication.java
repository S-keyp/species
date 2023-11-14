
package com.example.species;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
@EnableScheduling
public class SpeciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeciesApplication.class, args);
	}

}
