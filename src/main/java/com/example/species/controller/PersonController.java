package com.example.species.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.species.model.Person;
import com.example.species.repository.PersonRepository;
import com.example.species.service.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("rest/persons")
public class PersonController {

    @Autowired
	private PersonService personService;

    // @GetMapping("")
	// public String species(Model model) {
	// 	List<Person> personList = personRepository.findAll();
	// 	model.addAttribute("personList", personList);
	// 	return "persons/list_persons";
	// }

	@GetMapping("/{id}")
	public Person initUpdate(@PathVariable("id") Integer id) {
		return personService.findById(id);
		// Optional<Person> person = personRepository.findById(id);
		// if (person.isPresent()) {
		// 	return person.get();
		// }
		
	}

	// @PostMapping
	// public String createOrUpdate(@Valid Person person, BindingResult result) {
	// 	if(result.hasErrors()) {
	// 		return "persons/add";
	// 	} 
	// 	personRepository.save(person);
	// 	return "redirect:/persons";
	// }

	@GetMapping("/create")
	public String initCreate(Model model) {
		model.addAttribute(new Person());
		return "persons/add";
	}

	// @DeleteMapping("/delete")
	// public String delete(Person person) {
	// 	personRepository.delete(person);

	// 	return "redirect:/persons";
	// }
    
}
