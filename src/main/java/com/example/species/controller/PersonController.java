package com.example.species.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.species.model.Person;
import com.example.species.service.PersonService;


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
