package com.vagas.challenge.modules.candidacy.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vagas.challenge.modules.candidacy.dtos.CreateCandidacyDTO;
import com.vagas.challenge.modules.candidacy.entities.CandidacyEntity;
import com.vagas.challenge.modules.candidacy.services.CandidacyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidacy")
public class CandidacyController {
    final CandidacyService candidacyService;

    public CandidacyController(CandidacyService candidacyService) {
        this.candidacyService = candidacyService;
    }

    @PostMapping
    public ResponseEntity<CandidacyEntity> create(@RequestBody @Valid CreateCandidacyDTO requestDTO) {
        System.out.println(requestDTO);

        var candidacy = new CandidacyEntity();

        BeanUtils.copyProperties(requestDTO, candidacy);

        var newCandidacy = candidacyService.create(candidacy);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCandidacy);
    }

    @RequestMapping
    public ResponseEntity<List<CandidacyEntity>> findAll() {
        return ResponseEntity.status(200).body(candidacyService.getAll());
    }
}
