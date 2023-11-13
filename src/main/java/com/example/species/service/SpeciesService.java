package com.example.species.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.species.model.Species;
import com.example.species.repository.SpeciesRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class SpeciesService {
    @Autowired
    SpeciesRepository speciesRepository;

    public Species create(@Valid Species speciesToCreate) {
        return speciesRepository.save(speciesToCreate);
    }

    public Species update(@Valid Species updatedSpecies) {
        return speciesRepository.save(updatedSpecies);
    }

    public Page<Species> findAll(Pageable pageable) {
        return speciesRepository.findAll(pageable);
    }

    public Species findById(Integer id) {
        return speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteById(Integer id) {
        Species a = findById(id);
        speciesRepository.delete(a);
    }
}
