package com.example.species.mapper;

import com.example.species.dto.PersonDto;
import com.example.species.model.Animal;
import com.example.species.model.Person;

public class PersonDtoMapper {
    public static PersonDto toDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setAge(person.getAge());
        personDto.setName(person.getLastname().toUpperCase() + " " + person.getFirstname());

        String[] animalNames = person.getAnimals().stream()
                .map(Animal::getName)
                .toArray(String[]::new);

        personDto.setAnimals(animalNames);

        return personDto;
    }
}
