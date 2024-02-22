package com.vagas.challenge.modules.candidacy.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vagas.challenge.modules.candidacy.entities.CandidacyEntity;

public interface CandidacyRepository extends JpaRepository<CandidacyEntity, UUID> {
    
}
