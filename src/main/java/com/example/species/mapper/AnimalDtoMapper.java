package com.example.species.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.species.dto.AnimalDto;
import com.example.species.model.Animal;


public class AnimalDtoMapper {
    public static AnimalDto toDto(Animal animal) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animal.getId());
        animalDto.setName(animal.getName());
        animalDto.setSpecies(animal.getSpecies().getCommonName());
        animalDto.setColor(animal.getColor());

        List<String> personNames = animal.getPersons().stream()
                .map(person -> person.getFirstname() + " " + person.getLastname())
                .collect(Collectors.toList());

        animalDto.setPersons(String.join(", ", personNames));

        return animalDto;
    }
}