package com.example.species.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.species.enums.Sex;
import com.example.species.model.Animal;
import com.example.species.model.Species;
import com.example.species.repository.AnimalRepository;
import com.example.species.repository.SpeciesRepository;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
	private AnimalRepository animalRepository;
    @Autowired
	private SpeciesRepository speciesRepository;

    @GetMapping("")
	public String species(Model model) {
		List<Animal> animalList = animalRepository.findAll();
		model.addAttribute("animalList", animalList);
		return "animals/list_animals";
	}

	@GetMapping("/{id}")
	public String initUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Animal> animal = animalRepository.findById(id);
		if (animal.isPresent()) {
			model.addAttribute(animal.get());
			return "animals/update";
		}
		return "error";
	}

	@PostMapping(name = "save", path= "/save")
	public String createOrUpdate(Animal animalItem) {
		animalRepository.save(animalItem);
		return "redirect:/animals";
	}

	@GetMapping("/create")
	public String initCreate(Model model) {
		model.addAttribute(new Animal());
		model.addAttribute("sexValues", Sex.values());
		List<Species> speciesList = speciesRepository.findAll();
		model.addAttribute("species", speciesList);
		return "animals/add";
	}
    
}
