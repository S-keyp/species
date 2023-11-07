package com.example.species.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.species.model.Person;
import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByLastname(String firstName);
}
