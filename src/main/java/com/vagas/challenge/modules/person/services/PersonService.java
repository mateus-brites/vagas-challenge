package com.vagas.challenge.modules.person.services;

import org.springframework.stereotype.Service;

import com.vagas.challenge.modules.person.entities.PersonEntity;
import com.vagas.challenge.modules.person.repositories.PersonRepository;

@Service
public class PersonService {
    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonEntity create(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

}
