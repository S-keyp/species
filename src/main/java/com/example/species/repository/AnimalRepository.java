package com.example.species.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.species.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> { }
