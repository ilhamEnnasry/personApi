package com.example.personapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity

@Table(name = "Passport")
public class Passport {
    // Defines the primary key of the table.
    @Id
    //The database generates the ID automatically when a new row is inserted.
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_passport;
    private String passport_number;

    // Define a OneToOne relationship with Person.
    @OneToOne
    // Create a unique foreign key in the Passport table.
    @JoinColumn(name = "person_id", unique = true)
    @JsonBackReference
    private Person person;

    public Passport() {}

    public Passport(Long id_passport, String passport_number, Person person) {
        this.id_passport = id_passport;
        this.passport_number = passport_number;
        this.person = person;
    }

    // Getters & Setters
    public Long getId_passport() {
        return id_passport;
    }
    public void setId_passport(Long id_passport) {
        this.id_passport = id_passport;
    }

    public String getPassport_number() {
        return passport_number;
    }
    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

}
