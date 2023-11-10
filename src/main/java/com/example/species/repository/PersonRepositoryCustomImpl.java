package com.example.species.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.species.model.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
    
    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void deletePersonsWithOutAnimal(){
        String delete = "DELETE FROM Person p WHERE p.animals IS EMPTY";
        em.createQuery(delete).executeUpdate();
    }

    @Transactional
    public Person createPerson(String name){
        Person person = new Person();

        if (name.equals("")) person.setFirstname("John");
        else person.setFirstname(name);
        
        person.setLastname("Doe");
        em.persist(person);
        return person;
    }

    @Transactional
    public List<Person> bulkCreateMiguelPerson(Integer qty){
        List<Person> persons = new ArrayList<Person>();
        for(Integer i = 0; i < qty; i++){
            persons.add(createPerson("Miguel_%d".formatted(i)));
        }
        return persons;
    }
}
