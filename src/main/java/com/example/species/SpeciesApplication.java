
package com.example.species;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.species.model.Species;
import com.example.species.repository.AnimalRepository;
import com.example.species.repository.PersonRepository;
import com.example.species.repository.SpeciesRepository;

@SpringBootApplication
public class SpeciesApplication { // implements CommandLineRunner

	@Autowired
	private AnimalRepository animalRepo;
	@Autowired
	private PersonRepository personRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(SpeciesApplication.class, args);
	}

	@GetMapping("hello")
	public String hello() {
		return "<h1>Hello World</h1>";
	}

}
