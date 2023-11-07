package com.example.species.model;

import java.util.List;

import com.example.species.enums.Sex;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Animal {
    @Id
    private Integer id;
    private String name;
    private String color;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;
    @ManyToMany(mappedBy = "animals") 
    private List<Person> persons; 


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

    public Sex getAnimalSexe() {
        return this.sex;
    }

    public void setAnimalSexe(Sex animalSexe) {
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
