package com.vagas.challenge.candidacy;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ActiveProfiles;

import com.vagas.challenge.exceptions.EntityNotFoundException;
import com.vagas.challenge.modules.candidacy.dtos.CreateCandidacyDTO;
import com.vagas.challenge.modules.candidacy.entities.CandidacyEntity;
import com.vagas.challenge.modules.candidacy.repositories.CandidacyRepository;
import com.vagas.challenge.modules.candidacy.services.CandidacyService;
import com.vagas.challenge.modules.person.dtos.PersonDTO;
import com.vagas.challenge.modules.person.entities.PersonEntity;
import com.vagas.challenge.modules.person.services.PersonService;
import com.vagas.challenge.modules.vagas.dto.VagasDTO;
import com.vagas.challenge.modules.vagas.entities.VagasEntity;
import com.vagas.challenge.modules.vagas.services.VagasServices;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class CandidacyServiceTest {
    @Autowired
    CandidacyService candidacyService;

    @Autowired
    PersonService personService;

    @Autowired
    VagasServices vagasServices;

    @Autowired CandidacyRepository candidacyRepository;

    PersonEntity person;

    VagasEntity vagas;

    @BeforeAll
    public void createPersonAndVaga() {
        PersonDTO personDTO = new PersonDTO("Mateus", "QA", "B", 1);
        VagasDTO vagaDTO = new VagasDTO("Vagas", "QA Jr.", "QA tester", "A", 2);

        PersonEntity Person = new PersonEntity();
        VagasEntity Vagas = new VagasEntity();

        BeanUtils.copyProperties(personDTO, Person);
        BeanUtils.copyProperties(vagaDTO, Vagas);
    
        var newPerson = personService.create(Person);
        var newVaga = vagasServices.create(Vagas);

        this.person = newPerson;
        this.vagas = newVaga;
    }

    @Test
    @DisplayName("Shoulde create a new candidacy with sucess")
    public void createCandidacyWithSucess() {
        CreateCandidacyDTO candidacyDTO = new CreateCandidacyDTO(this.person.getId(), this.vagas.getId());
        CandidacyEntity Candidacy = new CandidacyEntity();

        BeanUtils.copyProperties(candidacyDTO, Candidacy);

        var newCandidacy = candidacyService.create(Candidacy);

        var size = candidacyRepository.findAll().size();

        Assertions.assertNotNull(newCandidacy.getId());
        Assertions.assertEquals(1, size);

    }
    
    @Test
    @DisplayName("Shoulde not be able to create a new candidacy with null argument value")
    public void createCandidacyErrorWithNullArgument() {
        CreateCandidacyDTO candidacyDTO = new CreateCandidacyDTO(this.person.getId(), null);
        CandidacyEntity Candidacy = new CandidacyEntity();

        BeanUtils.copyProperties(candidacyDTO, Candidacy);

        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,() -> candidacyService.create(Candidacy));

    }

    @Test
    @DisplayName("Shoulde not be able to create a new candidacy with invalid primarykey id argument value")
    public void createCandidacyErrorWithinvalidId() {
        CreateCandidacyDTO candidacyDTO = new CreateCandidacyDTO(this.person.getId(), UUID.randomUUID());
        CandidacyEntity Candidacy = new CandidacyEntity();

        BeanUtils.copyProperties(candidacyDTO, Candidacy);

        Assertions.assertThrows(EntityNotFoundException.class,() -> candidacyService.create(Candidacy));

    }
}
