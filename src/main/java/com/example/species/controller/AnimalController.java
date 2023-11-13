package com.example.species.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping(name="save", path="/save")
	public void createOrUpdate(Animal animal) {
		animalService.create(animal);
	}

	// @GetMapping("/create")
	// public String initCreate(Model model) {
	// 	model.addAttribute(new Animal());
	// 	model.addAttribute("sexValues", Sex.values());
	// 	List<Species> speciesList = speciesRepository.findAll();
	// 	model.addAttribute("species", speciesList);
	// 	return "animals/add";
	// }

	// @DeleteMapping("/delete")
	// public String delete(final Animal animal) {
	// 	animalRepository.delete(animal);

	// 	return "redirect:/animals";
	// }
    
}
