package com.example.species.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.species.enums.Sex;
import com.example.species.model.Animal;
import com.example.species.model.Species;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> { 
    List<Animal> findBySpecies(Species species);
    List<Animal> findByColorIn(List<String> colors);

    // @Query("SELECT CASE WHEN SIZE(a.person) > 0 THEN true ELSE false END FROM Animal a WHERE a = :id")Boolean hasOwner(@Param("id") Animal id);
    

    @Query("SELECT COUNT(a) from Animal where a.sex = :sex")
    Integer getQuantityBySex(@Param("sex") Sex sex);
}
