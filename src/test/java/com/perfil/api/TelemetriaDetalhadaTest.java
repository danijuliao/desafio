package com.perfil.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class TelemetriaDetalhadaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarTelemetriaDetalhada() throws Exception {
        mockMvc.perform(get("/telemetria/detalhada"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.servicos[0].nome").exists())
                .andExpect(jsonPath("$.servicos[0].quantidadeChamadas").isNumber())
                .andExpect(jsonPath("$.servicos[0].mediaTempoRespostaMs").isNumber())
                .andExpect(jsonPath("$.periodo.inicio").exists())
                .andExpect(jsonPath("$.periodo.fim").exists());
    }
}