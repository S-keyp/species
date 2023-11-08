package com.example.species.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.species.model.Animal;
import com.example.species.model.Person;
import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {
    List<Person> findByLastname(String firstName);
    List<Person> findByLastnameContainsOrFirstnameContains(String lastName, String firstName);
    List<Person> findByAgeGreaterThanEqual(Integer age);

    @Query("from Person where age between :age1 and :age2 order by age asc")
    List<Person> findAllByAgeBetween(
        @Param("age1") Integer age1, 
        @Param("age2") Integer age2
    );

    // @Query("from Person inner join Animal on ")
    // List<Person> findPersonByAnimal(@Param("animal.id") Animal animal);
}
