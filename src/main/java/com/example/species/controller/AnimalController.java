package com.example.species.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.species.dto.AnimalDto;
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

	// @PostMapping(path="/save")
	// public void create(@RequestBody Animal animal) {
	// 	animalService.create(animal);
	// }

	// Second method to get a page with get params
	@GetMapping("/page")
	public Page<AnimalDto> findPage(
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "25") int pageSize
		){
		return animalService.findPage(
			PageRequest.of(
				pageNumber, 
				pageSize
			)
		);
	}

	// @PostMapping(path="/update/{id}")
	// public void update(Animal animal) {
	// 	animalService.update(animal);
	// }

	// @DeleteMapping(path="/delete/{id}")
	// public void delete(@PathVariable("id") Integer id) {
	// 	animalService.deleteById(id);
	// }
}
