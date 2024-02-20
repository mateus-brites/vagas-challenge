package com.vagas.challenge.modules.vagas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vagas.challenge.modules.vagas.entities.VagasEntity;
import com.vagas.challenge.modules.vagas.repositories.VagasRepository;

@Service
public class VagasServices {
    final VagasRepository vagasRepository;

    public VagasServices(VagasRepository vagasRepository) {
        this.vagasRepository = vagasRepository;
    }

    public VagasEntity create(VagasEntity vaga) {
        var newVaga = vagasRepository.save(vaga);

        return newVaga;
    }

    public List<VagasEntity> getAll() {
        return vagasRepository.findAll();
    }
}
