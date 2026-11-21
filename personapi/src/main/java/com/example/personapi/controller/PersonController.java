package com.example.personapi.controller;

import com.example.personapi.entity.Person;
import com.example.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    // Inject PersonService to handle business logic.
    @Autowired
    private PersonService personService;

    // Return all persons
    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // Return a person by ID
    @GetMapping("/getPersonById/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonByID(id);
    }

    // add a new person
    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person) {

        return personService.addPerson(person);
    }

    // Updates an existing person by ID
    @PutMapping("/updatePersonById/{id}")
    public Person updatePersonById(@PathVariable Long id, @RequestBody Person newPerson) {

        return personService.updatePersonById(id, newPerson);
    }

    // Delete a person by ID
    @DeleteMapping("/deletePersonById/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
    }

    // Add a person using a database transaction
    @PostMapping("/addPersonWithTransaction")
    public void addPersonwithTransaction(@RequestBody Person person) {
        personService.addPersonWithTransaction(person);
    }


}
