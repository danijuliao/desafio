package com.perfil.api;

import com.perfil.api.service.RecomendacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class MotorRecomendacaoTest {

    @Autowired
    private RecomendacaoService recomendacaoService;

    @Test
    void deveRecomendarProdutosParaPerfilModerado() {
        var produtos = recomendacaoService.recomendarPorPerfil("Moderado");
        assertThat(produtos.get(0).getRisco()).isIn("Baixo", "Médio");
    }
}