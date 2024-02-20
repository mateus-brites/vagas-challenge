package com.vagas.challenge.modules.vagas.services;

import com.vagas.challenge.modules.vagas.entities.VagasEntity;
import com.vagas.challenge.modules.vagas.repositories.VagasRepository;

public class VagasServices {
    final VagasRepository vagasRepository;

    public VagasServices(VagasRepository vagasRepository) {
        this.vagasRepository = vagasRepository;
    }

    public VagasEntity create(VagasEntity vaga) {
        var newVaga = vagasRepository.save(vaga);

        return newVaga;
    }
}
