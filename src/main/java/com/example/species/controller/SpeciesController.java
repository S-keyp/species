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

import com.example.species.model.Species;
import com.example.species.repository.SpeciesRepository;
import com.example.species.service.SpeciesService;

@RestController
@RequestMapping("rest/species")
public class SpeciesController {

    @Autowired
	private SpeciesService speciesService;

    // @GetMapping("")
	// public String species(Model model) {
	// 	List<Species> speciesList = speciesRepo.findAll();
	// 	model.addAttribute("speciesList", speciesList);
	// 	return "species/list_species";
	// }

	@GetMapping("/{id}")
	public Species initUpdate(@PathVariable("id") Integer id) {
		return speciesService.findById(id);
	}

	// @PostMapping(name="save", path="/save")
	// public String createOrUpdate(Species speciesItem) {
	// 	speciesRepo.save(speciesItem);
	// 	return "redirect:/species";
	// }


	// @GetMapping("/create")
	// public String initCreate(Model model) {
	// 	model.addAttribute(new Species());
	// 	return "species/add";
	// }

	// @DeleteMapping("/delete")
	// public String delete(Species species) {
	// 	speciesRepo.delete(species);

	// 	return "redirect:/species";
	// }

    
}
