package com.example.species.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.species.model.Species;
import com.example.species.service.SpeciesService;

@RestController
@RequestMapping("rest/species")
public class SpeciesController {
    @Autowired
	private SpeciesService speciesService;

    @GetMapping("")
	public Page<Species> species(Pageable pageable) {
		return speciesService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Species initUpdate(@PathVariable("id") Integer id) {
		return speciesService.findById(id);
	}

	@PostMapping(path="/save")
	public void createOrUpdate(@RequestBody Species species) {
		speciesService.create(species);
	}

	// @PostMapping(path="/update/{id}")
	// public void update(Person person) {
	// 	personService.update(person);
	// }

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		speciesService.deleteById(id);
	}
}
