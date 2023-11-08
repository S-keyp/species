package com.example.species;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.species.enums.Sex;
import com.example.species.model.Person;
import com.example.species.model.Species;
import com.example.species.repository.AnimalRepository;
import com.example.species.repository.PersonRepository;
import com.example.species.repository.SpeciesRepository;

@SpringBootApplication
public class SpeciesApplication implements CommandLineRunner {

	@Autowired
	private AnimalRepository animalRepo;
	@Autowired
	private PersonRepository personRepo;
	@Autowired
	private SpeciesRepository speciesRepo;;

	public static void main(String[] args) {
		SpringApplication.run(SpeciesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// DELETE (RIP Henry?)
		System.out.println("%d".formatted(personRepo.findAll().size()));
		
		Person person = new Person();
		person.setAge(22);
		person.setId(1);
		person.setFirstName("Henry");
		person.setLastName("Lamarque");
		personRepo.delete(person);
		
		System.out.println("%d".formatted(personRepo.findAll().size()));
		
		// CREATE (Revive Henry?)
		Person person2 = new Person();
		person2.setAge(22);
		person2.setId(1);
		person2.setFirstName("Henry");
		person2.setLastName("Lamarque");
		personRepo.save(person2);

		// SELECT
		Optional<Person> person3 = personRepo.findById(1);
		if(person3.isPresent()) {
			System.out.println("Personne trouvé, c'est: %s".formatted(person3.get()));
			person3.get().setFirstName("Plus Henry");
			personRepo.save(person3.get());
			System.out.println("Personne updated");
		} else {
			System.err.println("Personne non trouvée");
		}
		

		// READ all persons
		// System.out.println(personRepo.findAll());

		// System.out.println("findbylastname: Lamarque || ");
		// System.out.println(personRepo.findByLastname("Lamarque"));



		// REQUETES DERIVEES
		// System.out.println("");
		// System.out.println("");
		// System.out.println("");
		// SPECIES REPO
		// System.out.println("-------------------------------");
		// System.out.println("SPECIES Requêtes dérivées");
		// System.out.println("-------------------------------");
		// System.out.println(speciesRepo.findFirstBycommonName("Chien"));
		// System.out.println(speciesRepo.findBylatinNameAllIgnoreCaseContains("feLIs"));
		
		// PERSON REPO
		// System.out.println("-------------------------------");
		// System.out.println("PERSON Requêtes dérivées");
		// System.out.println("-------------------------------");
		// System.out.println(personRepo.findByLastnameContainsOrFirstnameContains("Nero", "Sylvie"));
		// System.out.println(personRepo.findByAgeGreaterThanEqual(33));
		
		// PERSON REPO
		// System.out.println("-------------------------------");
		// System.out.println("ANIMAL Requêtes dérivées");
		// System.out.println("-------------------------------");
		// Species chat = new Species();
		// chat.setId(1);
		// chat.setCommonName("Chat");
		// chat.setLatinName("Felis silvestris catus");
		// System.out.println(animalRepo.findBySpecies(chat));
		// List<String> colors = List.of("Blanc","Noir");
		// System.out.println(animalRepo.findByColorIn(colors));









		// TP05 Query sur Repo Spring
		// System.out.println("");
		// System.out.println("");
		// System.out.println("");
		// System.out.println("-------------------------------");
		// System.out.println("-------------------------------");
		// System.out.println("QUERY sur Repo Spring");
		// System.out.println("-------------------------------");
		// System.out.println("-------------------------------");
		// System.out.println("");
		
		// SPECIES REPO
		// System.out.println("-------------------------------");
		// System.out.println("SPECIES");
		// System.out.println("-------------------------------");
		// System.out.println(speciesRepo.findAllByCommonName("Chat"));
		// System.out.println(speciesRepo.findAllSpeciesCommonNameLike("Ch"));
		
		// PERSON REPO
		// System.out.println("-------------------------------");
		// System.out.println("PERSON");
		// System.out.println("-------------------------------");
		// System.out.println(personRepo.findAllByAgeBetween(32, 50));
		
		// ANIMAL REPO
		System.out.println("-------------------------------");
		System.out.println("ANIMAL");
		System.out.println("-------------------------------");
		
		System.out.println(animalRepo.getQuantityBySex(Sex.M));











		// System.out.println("");
		// System.out.println("");
		// System.out.println("");
		// System.out.println("-------------------------------");
		// System.out.println("-------------------------------");
		// System.out.println("QUERY sur Repo Spring");
		// System.out.println("-------------------------------");
		// System.out.println("-------------------------------");
		// System.out.println("");
		personRepo.deletePersonsWithOutAnimal();
		System.out.println(personRepo.createPerson("Oink oink"));
		System.out.println(personRepo.bulkCreateMiguelPerson(10));



	}

	@GetMapping("hello")
	public String hello() {
		return "<h1>Hello World</h1>";
	}

}
