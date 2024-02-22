package com.vagas.challenge.modules.candidacy.entities;

import java.util.UUID;

import com.vagas.challenge.modules.person.entities.PersonEntity;
import com.vagas.challenge.modules.vagas.entities.VagasEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidacy")
public class CandidacyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, nullable = false, updatable = false)
    private PersonEntity person;

    @Column(name = "person_id", nullable = false)
    private UUID personId;

    @ManyToOne
    @JoinColumn(name = "vagas_id", insertable = false, nullable = false, updatable = false)
    private VagasEntity vagas;

    @Column(name = "vagas_id", nullable = false)
    private UUID vagasId;

    @Column(nullable = true)
    private Integer score;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public VagasEntity getVagas() {
        return vagas;
    }

    public void setVagas(VagasEntity vagas) {
        this.vagas = vagas;
    }

    public UUID getVagasId() {
        return vagasId;
    }

    public void setVagasId(UUID vagasId) {
        this.vagasId = vagasId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
