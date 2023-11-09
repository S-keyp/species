package com.example.species.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.species.model.Species;
import com.example.species.repository.SpeciesRepository;

@Controller
public class SpeciesController {

    @Autowired
	private SpeciesRepository speciesRepo;;

    @GetMapping("/species")
	public String species(Model model) {
		List<Species> speciesList = speciesRepo.findAll();
		model.addAttribute("speciesList", speciesList);
		return "list_species";
	}
    
}
