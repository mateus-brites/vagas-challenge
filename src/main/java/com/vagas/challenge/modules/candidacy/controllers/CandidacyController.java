package com.vagas.challenge.modules.candidacy.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vagas.challenge.modules.candidacy.dtos.CreateCandidacyDTO;
import com.vagas.challenge.modules.candidacy.dtos.ResponseCreateCandidacyDTO;
import com.vagas.challenge.modules.candidacy.entities.CandidacyEntity;
import com.vagas.challenge.modules.candidacy.services.CandidacyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidacy")
public class CandidacyController {
    final CandidacyService candidacyService;

    @Autowired
    ModelMapper modelMapper;

    public CandidacyController(CandidacyService candidacyService) {
        this.candidacyService = candidacyService;
    }

    @PostMapping
    public ResponseEntity<ResponseCreateCandidacyDTO> create(@RequestBody @Valid CreateCandidacyDTO requestDTO) {

        var candidacy = new CandidacyEntity();

        BeanUtils.copyProperties(requestDTO, candidacy);

        var newCandidacy = candidacyService.create(candidacy);

        var responseMap = modelMapper.map(newCandidacy, ResponseCreateCandidacyDTO.class);



        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @RequestMapping
    public ResponseEntity<List<CandidacyEntity>> findAll() {
        return ResponseEntity.status(200).body(candidacyService.getAll());
    }
}
