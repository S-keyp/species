package com.example.species.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.species.model.Animal;
import com.example.species.repository.AnimalRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    public Animal create(@Valid Animal animalToCreate) {
        return this.animalRepository.save(animalToCreate);
    }

    public Animal update(@Valid Animal updatedAnimal) {
        return this.animalRepository.save(updatedAnimal);
    }

    public Page<Animal> findAll(Pageable pageable) {
        return this.animalRepository.findAll(pageable);
    }

    public Animal findById(Integer id) {
        return this.animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
