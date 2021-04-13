package com.pvobrien.socialJump.controller;

import com.pvobrien.socialJump.domain.Person;
import com.pvobrien.socialJump.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/people")
    public Iterable<Person> getPeople() {
        return personRepository.findAll();
    }
}
