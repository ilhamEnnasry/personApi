package com.example.personapi.service;

import com.example.personapi.entity.Person;
import com.example.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    // Inject PersonRepository to access the database.
    @Autowired
    private PersonRepository personRepository;

    // Find all persons from the database
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Find a person by ID or return null if not found
    public Person getPersonByID(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    // Add a new person in the database
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    // Update an existing person's information
    public Person updatePersonById(Long id, Person newPerson) {
        // Find the person to update
        Person existingPerson = personRepository.findById(id).orElse(null);

        // Stop if the person does not exist
        if(existingPerson == null ) {
            return null;
        }

        // Update the person's fields
        existingPerson.setName(newPerson.getName());
        existingPerson.setAge(newPerson.getAge());

        // Save the updated person
        return personRepository.save(existingPerson);
    }

    // Delete a person from the database by ID
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    // Save a person inside a database transaction
    @Transactional
    public Person addPersonWithTransaction(Person person) {

        // Save the person inside the transaction
        Person personSaved = personRepository.save(person);

        // Throwing a runtime exception here to trigger a rollback
        //throw new RuntimeException("add Person with Transaction test");

        return personSaved;
    }


}
