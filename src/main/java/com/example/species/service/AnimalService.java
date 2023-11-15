package com.example.species.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.exception.EntityToCreateHasAnIdException;
import com.example.species.dto.AnimalDto;
import com.example.species.mapper.AnimalDtoMapper;
import com.example.species.model.Animal;
import com.example.species.repository.AnimalRepository;


import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class  AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    // public Animal create(@Valid Animal animalToCreate) {
    //     return animalRepository.save(animalToCreate);
    // }

    // public Animal update(@Valid Animal updatedAnimal) {
    //     return animalRepository.save(updatedAnimal);
    // }

    public Page<Animal> findAll(Pageable pageable) {
        return animalRepository.findAll(pageable);
    }

    // public Animal findById(Integer id) {
    //     return animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    // }

    // public Page<Animal> findPage(Pageable pageable){
	// 	return animalRepository.findAll(pageable);
	// }

    // public void deleteById(Integer id) {
    //     animalRepository.delete(findById(id));
    // }

    public Animal findById(Integer id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID : " + id + " introuvable"));

    }

    public Animal createAnimal(@Valid Animal createAnimal) {
        if (createAnimal.getId() != 0) {
            throw new EntityToCreateHasAnIdException("présence ID ");
        }
        return animalRepository.save(createAnimal);
    }

    public Animal updateAnimal(@Valid Animal updateAnimal) {
        boolean idInupdateAnimal = animalRepository.existsById(updateAnimal.getId());
        if (updateAnimal.getId() == 0) {
            throw new EntityToCreateHasAnIdException("abscence d ID ");
        }
        if (idInupdateAnimal != false) {
            return animalRepository.save(updateAnimal);
        }
        throw new EntityNotFoundException("ID : " + updateAnimal.getId() + " introuvable");
    }

    public Animal deleteAnimal(Integer id) {
        Animal animalToDelete = animalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID : " + id + " introuvable"));
        if (animalToDelete != null) {
            animalRepository.deleteById(id);
        }
        return animalToDelete;
    }

    public Page<AnimalDto> findPage(Pageable pageable) {
        Page<Animal> pageAnimal = animalRepository.findAll(pageable);
        return pageAnimal.map((animal) -> AnimalDtoMapper.toDto(animal));
    }

}
