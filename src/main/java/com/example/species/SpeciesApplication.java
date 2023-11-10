
package com.example.species;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class SpeciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeciesApplication.class, args);
	}

	@GetMapping("hello")
	public String hello() {
		return "<h1>Hello World</h1>";
	}

}
