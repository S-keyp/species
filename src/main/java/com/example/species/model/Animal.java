package com.example.species.model;

import java.util.List;

import com.example.species.enums.Sex;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String color;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "species_id")
    private Species species;

    @JsonIgnore
    @ManyToMany(
        mappedBy = "animals", 
        cascade = { CascadeType.PERSIST}
    ) 
    private List<Person> persons; 
    

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setSex(Sex animalSexe) {
        this.sex = animalSexe;
    }

    public List<Person> getAnimals() {
        return this.persons;
    }

    public void setAnimals(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", name=" + name + "]";
    }

}
