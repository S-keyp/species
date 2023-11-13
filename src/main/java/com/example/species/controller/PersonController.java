package com.example.species.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.species.model.Animal;
import com.example.species.model.Person;
import com.example.species.service.AnimalService;
import com.example.species.service.PersonService;


@RestController
@RequestMapping("rest/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

    @GetMapping("")
	public Page<Person> species(Pageable pageable) {
		return personService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public Person initUpdate(@PathVariable("id") Integer id) {
		return this.personService.findById(id);
	}

	@PostMapping(path="/save")
	public void create(@RequestBody Person person) {
		personService.create(person);
	}
	
	// @PostMapping(path="/update/{id}")
	// public void update(Person person) {
	// 	personService.update(person);
	// }

	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		personService.deleteById(id);
	}
    
}
