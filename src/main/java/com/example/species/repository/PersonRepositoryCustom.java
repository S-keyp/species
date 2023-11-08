package com.example.species.repository;

import java.util.List;

import com.example.species.model.Person;

public interface PersonRepositoryCustom {
    Person createPerson(String name);
    void deletePersonsWithOutAnimal();
    List<Person> bulkCreateMiguelPerson(Integer qty);
}
