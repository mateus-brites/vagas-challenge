package com.vagas.challenge.modules.vagas.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vagas.challenge.modules.vagas.dto.VagasDTO;
import com.vagas.challenge.modules.vagas.entities.VagasEntity;
import com.vagas.challenge.modules.vagas.services.VagasServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vaga")
public class VagasController {
    final VagasServices vagasServices;

    public VagasController(VagasServices vagasServices) {
        this.vagasServices = vagasServices;
    }

    @PostMapping
    public ResponseEntity<VagasEntity> create(@RequestBody @Valid VagasDTO dto){
        var Vaga = new VagasEntity();

        BeanUtils.copyProperties(dto, Vaga);

        var newVaga = vagasServices.create(Vaga);

        return ResponseEntity.status(201).body(newVaga);
    }

    @GetMapping
    public ResponseEntity<List<VagasEntity>> getAll() {
        return ResponseEntity.status(200).body(vagasServices.getAll());
    }
}
