package com.example.species.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.species.model.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer>  { }
