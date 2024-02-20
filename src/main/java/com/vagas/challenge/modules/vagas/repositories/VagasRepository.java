package com.vagas.challenge.modules.vagas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vagas.challenge.modules.vagas.entities.VagasEntity;

public interface VagasRepository extends JpaRepository<VagasEntity, UUID> {
    
}
