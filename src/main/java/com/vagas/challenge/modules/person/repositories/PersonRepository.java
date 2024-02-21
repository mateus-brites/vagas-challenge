package com.vagas.challenge.modules.person.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vagas.challenge.modules.person.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
    
}
