package com.vagas.challenge.modules.candidacy.dtos;

import java.util.UUID;

public class ResponseCreateCandidacyDTO {
    UUID id;
    UUID person_id;
    UUID vagas_id;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getPerson_id() {
        return person_id;
    }
    public void setPerson_id(UUID person_id) {
        this.person_id = person_id;
    }
    public UUID getVagas_id() {
        return vagas_id;
    }
    public void setVagas_id(UUID vagas_id) {
        this.vagas_id = vagas_id;
    }
}
