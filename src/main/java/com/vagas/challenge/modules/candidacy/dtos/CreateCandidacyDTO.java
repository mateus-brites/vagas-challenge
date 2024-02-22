package com.vagas.challenge.modules.candidacy.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record CreateCandidacyDTO(
    @NotNull UUID personId,
    @NotNull UUID vagasId
) {
    
}
