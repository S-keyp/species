package com.example.species.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Person {

    @Id
    private Integer id;
    private int age;
    private String firstname;
    private String lastname;
    @ManyToMany
    @JoinTable(name = "person_animals", 
        joinColumns = @JoinColumn(name = "person_id" ),
        inverseJoinColumns = @JoinColumn(name = "animals_id")
    ) // Nom de la table de jointure si nécessaire
    @Column(name = "id_person")
    private List<Animal> animals;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", firstName=" + firstname + "]";
    }

}
