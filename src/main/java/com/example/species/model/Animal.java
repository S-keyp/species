package com.example.species.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Animal {
    private enum AnimalSexe{
        M,
        F
    }

    @Id
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AnimalSexe sex;
    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;
    @ManyToMany(mappedBy = "animals") // Utilisez "animals" pour représenter la relation Many-to-Many
    private List<Person> persons; // Supposons que vous avez une classe "Person" pour représenter les personnes


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

    public AnimalSexe getAnimalSexe() {
        return this.sex;
    }

    public void setAnimalSexe(AnimalSexe animalSexe) {
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
