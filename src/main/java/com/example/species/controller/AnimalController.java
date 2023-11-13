package com.example.species.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.species.model.Animal;
import com.example.species.service.AnimalService;


@RestController
@RequestMapping("rest/animals")
public class AnimalController {

    @Autowired
	private AnimalService animalService;

    @GetMapping("")
	public Page<Animal> species(Pageable pageable) {
		return animalService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Animal initUpdate(@PathVariable("id") Integer id) {
		return this.animalService.findById(id);
	}

	@PostMapping(path="/save")
	public void create(@RequestBody Animal animal) {
		System.out.println("--------------------------------");
		System.out.println(animal);
		System.out.println("--------------------------------");
		animalService.create(animal);
	}

	// @PostMapping(path="/update/{id}")
	// public void update(Animal animal) {
	// 	animalService.update(animal);
	// }

	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		animalService.deleteById(id);
	}
}
