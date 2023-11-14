package com.example.species.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.species.model.Species;
import com.example.species.repository.SpeciesRepository;

@Controller
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
	private SpeciesRepository speciesRepo;;

    @GetMapping("")
	public String species(Model model) {
		List<Species> speciesList = speciesRepo.findAll();
		model.addAttribute("speciesList", speciesList);
		return "species/list_species";
	}

	@GetMapping("/{id}")
	public String initUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Species> species = speciesRepo.findById(id);
		if (species.isPresent()) {
			model.addAttribute(species.get());
			return "species/update";
		}
		return "error";
	}

	@PostMapping(name="save", path="/save")
	public String createOrUpdate(Species species) {
		speciesRepo.save(species);
		return "redirect:/species";
	}


	@GetMapping("/create")
	public String initCreate(Model model) {
		model.addAttribute(new Species());
		return "species/add";
	}

	@DeleteMapping("/delete")
	public String delete(Species species) {
		speciesRepo.delete(species);

		return "redirect:/species";
	}

    
}
