package com.vagas.challenge.modules.candidacy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vagas.challenge.exceptions.EntityNotFoundException;
import com.vagas.challenge.modules.candidacy.entities.CandidacyEntity;
import com.vagas.challenge.modules.candidacy.repositories.CandidacyRepository;
import com.vagas.challenge.modules.person.repositories.PersonRepository;
import com.vagas.challenge.modules.vagas.repositories.VagasRepository;

@Service
public class CandidacyService {
    final CandidacyRepository candidacyRepository;
    final PersonRepository personRepository;
    final VagasRepository vagasRepository;

    public CandidacyService(
        CandidacyRepository candidacyRepository,
        PersonRepository personRepository,
        VagasRepository vagasRepository
        ) {
        this.candidacyRepository = candidacyRepository;
        this.personRepository = personRepository;
        this.vagasRepository = vagasRepository;
    }

    public CandidacyEntity create(CandidacyEntity candidacyEntity) {
        var personExist = personRepository.findById(candidacyEntity.getPersonId()).isPresent();
        var vagasExist= vagasRepository.findById(candidacyEntity.getVagasId()).isPresent();

        if (!personExist) {
            throw new EntityNotFoundException("personId");
        }

        if (!vagasExist) {
            System.out.println("ERROUuuuu");
            throw new EntityNotFoundException("vagasId");
        }

        return candidacyRepository.save(candidacyEntity);
    }

    public List<CandidacyEntity> getAll() {
        return candidacyRepository.findAll();
    }
}
