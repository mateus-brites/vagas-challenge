package com.vagas.challenge.modules.person.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonDTO(
    @NotBlank String nome,
    @NotBlank String profissao,
    @NotBlank String localizacao,
    @NotNull Integer nivel
) {
}
