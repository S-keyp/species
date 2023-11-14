package com.example.species.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.species.model.Animal;
import com.example.species.model.Person;
import com.example.species.repository.PersonRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person create(@Valid Person personToCreate) {
        return personRepository.save(personToCreate);
    }

    public Person update(@Valid Person updatedPerson) {
        return personRepository.save(updatedPerson);
    }

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Page<Person> findPage(Pageable pageable){
		return personRepository.findAll(pageable);
	}

    public void deleteById(Integer id) {
        personRepository.delete(findById(id));
    }
}
