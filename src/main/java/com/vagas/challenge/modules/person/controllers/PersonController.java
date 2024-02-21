package com.vagas.challenge.modules.person.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vagas.challenge.modules.person.dtos.PersonDTO;
import com.vagas.challenge.modules.person.entities.PersonEntity;
import com.vagas.challenge.modules.person.services.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {
    final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonEntity> create(@RequestBody @Valid PersonDTO requestDTO) {
        var person = new PersonEntity();
        BeanUtils.copyProperties(requestDTO, person);

        var newPerson = personService.create(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPerson);
    }

}
