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
public class  AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    public Animal create(@Valid Animal animalToCreate) {
        return animalRepository.save(animalToCreate);
    }

    public Animal update(@Valid Animal updatedAnimal) {
        return animalRepository.save(updatedAnimal);
    }

    public Page<Animal> findAll(Pageable pageable) {
        return animalRepository.findAll(pageable);
    }

    public Animal findById(Integer id) {
        return animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Page<Animal> findPage(Pageable pageable){
		return animalRepository.findAll(pageable);
	}

    public void deleteById(Integer id) {
        animalRepository.delete(findById(id));
    }
}
