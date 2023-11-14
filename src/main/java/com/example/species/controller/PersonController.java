package com.example.species.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.species.model.Person;
import com.example.species.repository.PersonRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
	private PersonRepository personRepository;

    @GetMapping("")
	public String species(Model model) {
		List<Person> personList = personRepository.findAll();
		model.addAttribute("personList", personList);
		return "persons/list_persons";
	}

	@GetMapping("/{id}")
	public String initUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isPresent()) {
			model.addAttribute(person.get());
			return "persons/update";
		}
		return "error";
	}

	@PostMapping(name="save", path="/save")
	public String createOrUpdate(@Valid Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "persons/add";
		} 
		personRepository.save(person);
		return "redirect:/persons";
	}

	@GetMapping("/create")
	public String initCreate(Model model) {
		model.addAttribute(new Person());
		return "persons/add";
	}

	@DeleteMapping(name="delete", path="/delete")
	public String delete(Person person) {
		personRepository.delete(person);

		return "redirect:/persons";
	}

	@PostMapping(name="create10", path="/create10")
	public String bulkCreate(final int count) {
		personRepository.bulkCreateMiguelPerson(count);

		return "redirect:/persons";
	}

	@DeleteMapping(name="deleteWOPets", path="/delete-without-pets")
	@Transactional
	public String deleteWithoutPets() {
		personRepository.deletePersonsWithOutAnimal();

		return "redirect:/persons";
	}
    
}
