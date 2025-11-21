package com.perfil.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class SimulacaoErroTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarErroParaClienteInexistente() throws Exception {
        String jsonRequest = """
            {
                               "prazoMeses": 12,
                "tipoProduto": "CDB"
            }
            """;

        mockMvc.perform(post("/simular-investimento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isNotFound());
    }

    @Test
    void deveRetornarErroParaPrazoInvalido() throws Exception {
        String jsonRequest = """
            {
                "clienteId": 123,
                "valor": 10000.00,
                "prazoMeses": 0,
                "tipoProduto": "CDB"
            }
            """;

        mockMvc.perform(post("/simular-investimento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }
}
