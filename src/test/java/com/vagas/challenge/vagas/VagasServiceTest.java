package com.vagas.challenge.vagas;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import com.vagas.challenge.modules.vagas.dto.VagasDTO;
import com.vagas.challenge.modules.vagas.entities.VagasEntity;
import com.vagas.challenge.modules.vagas.repositories.VagasRepository;
import com.vagas.challenge.modules.vagas.services.VagasServices;

@SpringBootTest
@ActiveProfiles("test")
public class VagasServiceTest {
    @Autowired
    VagasServices vagasServices;

    @Autowired
    VagasRepository vagasRepository;

    @Test
    @DisplayName("Shoulde create a new vaga with sucess")
    void createVagasSucess() {
        var vaga = new VagasEntity();
        var dto = new VagasDTO(
            "Vagas",
            "Backend Java",
            "Backend Java Pleno",
            "Campinas",
            2);
        
        BeanUtils.copyProperties(dto, vaga);

        var newVaga = vagasServices.create(vaga);

        var size = vagasRepository.findAll().size();

        Assertions.assertEquals(newVaga.getEmpresa(), "Vagas");
        Assertions.assertNotNull(newVaga.getId());
        Assertions.assertEquals(1, size);

        System.out.println(newVaga);
    }

    @Test
    @DisplayName("Shoulde not be able create a new vaga with null value")
    void createVagaFail() {
        var vaga = new VagasEntity();
        var dto = new VagasDTO(
            "Vagas",
            null,
            "Backend Java Pleno",
            "Campinas",
            2);

        BeanUtils.copyProperties(dto, vaga);
    
        Assertions.assertThrows(DataIntegrityViolationException.class,() -> vagasServices.create(vaga));
    }
}
