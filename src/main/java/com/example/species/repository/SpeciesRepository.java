package com.example.species.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.species.model.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer>  {
    Species findFirstBycommonName(String commonName);
    List<Species> findBylatinNameAllIgnoreCaseContains(String latinName);
}
