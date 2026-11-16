package com.example.personapi.entity;

import jakarta.persistence.*;

// Hibernate will map this Java class to a database table.
@Entity
// Specifies the database table name.
@Table(name = "person")
public class Person {
    // Defines the primary key of the table.
    @Id
    //The database generates the ID automatically when a new row is inserted.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    // No-argument constructor (a constructor without parameters).
    // JPA/Hibernate requires it to create an empty Person object when retrieving data from the database.
    // After creating the object, Hibernate populates its fields with the values retrieved from the database.
    public Person() {
    }

    // Create a Person object with a name and age.
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters

    // Returns the person's ID.
    public Long getId() {
        return id;
    }

    // Returns the person's name.
    public String getName() {
        return name;
    }

    // Updates the person's name.
    public void setName(String name) {
        this.name = name;
    }

    // Returns the person's age.
    public int getAge() {
        return age;
    }

    // Updates the person's age.
    public void setAge(int age) {
        this.age = age;
    }
}
