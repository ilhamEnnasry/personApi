package com.example.personapi.controller;

import com.example.personapi.entity.Person;
import com.example.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/getPersonById/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person) {

        return personRepository.save(person);
    }

    @PutMapping("/updatePersonById/{id}")
    public Person updatePersonById(@PathVariable Long id, @RequestBody Person newPerson) {
        Person existingPerson = personRepository.findById(id).orElse(null);

        if (existingPerson == null) {
            return null;
        }

        existingPerson.setName(newPerson.getName());
        existingPerson.setAge(newPerson.getAge());

        return personRepository.save(existingPerson);
    }

    @DeleteMapping("/deletePersonById/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
