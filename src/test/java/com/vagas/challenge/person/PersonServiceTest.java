package com.vagas.challenge.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import com.vagas.challenge.modules.person.dtos.PersonDTO;
import com.vagas.challenge.modules.person.entities.PersonEntity;
import com.vagas.challenge.modules.person.repositories.PersonRepository;
import com.vagas.challenge.modules.person.services.PersonService;

@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {
    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @Test
    @DisplayName("Shoulde create a new vaga with sucess")
    private void createPersonSucess() {
        var personDTO = new PersonDTO("John Doe", "Engenheiro de Software", "C", 2);
        var person = new PersonEntity();

        BeanUtils.copyProperties(personDTO, person);

        var newPerson = personService.create(person);

        var size = personRepository.findAll().size();

        Assertions.assertEquals(newPerson.getNome(), "John Doe");
        Assertions.assertNotNull(newPerson.getId());
        Assertions.assertEquals(1, size);
    }

    @Test
    @DisplayName("Shoulde not be able create a new person with null argument value")
    void createPersonFail() {
        var person = new PersonEntity();
        var dto = new PersonDTO("John Doe", "Engenheiro de Software", null, 2);

        BeanUtils.copyProperties(dto, person);
    
        Assertions.assertThrows(DataIntegrityViolationException.class,() -> personService.create(person));
    }
}
