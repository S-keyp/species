package com.example.species.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.species.enums.Sex;
import com.example.species.model.Animal;
import com.example.species.model.Species;
import com.example.species.repository.AnimalRepository;
import com.example.species.repository.SpeciesRepository;
import com.example.species.service.AnimalService;
import com.example.species.service.SpeciesService;

@RestController
@RequestMapping("rest/animals")
public class AnimalController {

    @Autowired
	private AnimalService animalService;

    // @GetMapping("")
	// public String species(Model model) {
	// 	List<Animal> animalList = animalRepository.findAll();
	// 	model.addAttribute("animalList", animalList);
	// 	return "animals/list_animals";
	// }

	@GetMapping("/{id}")
	public Animal initUpdate(@PathVariable("id") Integer id) {
		return this.animalService.findById(id);
	}

	// @PostMapping
	// public String createOrUpdate(Animal animal) {
	// 	System.out.println(animal);
	// 	animalRepository.save(animal);
	// 	return "redirect:/animals";
	// }

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
