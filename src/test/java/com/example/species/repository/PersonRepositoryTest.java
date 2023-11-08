package com.example.species.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.species.model.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class PersonRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    PersonRepository personRepo;

    @BeforeEach
    public void setup(){
        em.clear();
        Person person = new Person();
        person.setFirstName("qsdfj");
        person.setAge(25);
        person.setLastName("qsmdflkj");
        Person person2 = new Person();
        person.setFirstName("qsdfffffff");
        person.setAge(30);
        person.setLastName("ùmjmljk");
        Person person3 = new Person();
        person.setFirstName("qsdkbjlmjsffj");
        person.setAge(20);
        person.setLastName("dfdkfjk");

        em.persist(person);
        em.persist(person2);
        em.persist(person3);

        em.flush();
    }

    @Test
    public void testPersonByAge() {
        List<Person> persons = personRepo.findByAgeGreaterThanEqual(25);
        Assertions.assertEquals(persons.size(), 2);
    }
}
