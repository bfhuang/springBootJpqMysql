package com.jpaexample.controller;

import java.util.Date;
import java.util.List;

import com.jpaexample.model.Person;
import com.jpaexample.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Dinesh.Rajput
 */
@RestController
@RequestMapping("/person")
public class HelloController {

    @Autowired
    PersonRepository personRepository;

    /**
     * GET /create  --> Create a new person and save it in the database.
     */
    @RequestMapping("/create")
    public Person create(Person person) {
        Person save = personRepository.save(person);
        return save;
    }

    /**
     * GET /read  --> Read a booking by booking id from the database.
     */
    @RequestMapping("/read")
    public Person read(@RequestParam Long personId) {
        Person person = personRepository.findOne(personId);
        return person;
    }

    /**
     * GET /update  --> Update a booking record and save it in the database.
     */
    @RequestMapping("/update")
    public Person update(@RequestParam Long personId, @RequestParam String firstName) {
        Person person = personRepository.findOne(personId);
        person.setFirstName(firstName);
        Person save = personRepository.save(person);
        return save;
    }

    @RequestMapping("/readAll")
    public List<Person> readAll() {
        Iterable<Person> all = personRepository.findAll();

        return (List<Person>) all;
    }

    /**
     * GET /delete  --> Delete a booking from the database.
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam Long personId) {
        personRepository.delete(personId);
        return "booking #" + personId + " deleted successfully";
    }
}