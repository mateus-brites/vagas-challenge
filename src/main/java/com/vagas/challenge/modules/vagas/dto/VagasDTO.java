package com.vagas.challenge.modules.vagas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VagasDTO(
    @NotBlank String empresa,
    @NotBlank String titulo,
    @NotBlank String descricao,
    @NotBlank String localizacao,
    @NotNull Integer nivel) {
    
}

