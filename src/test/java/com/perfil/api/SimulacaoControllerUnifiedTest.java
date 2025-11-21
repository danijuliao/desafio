package com.perfil.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfil.api.controller.SimulacaoController;
import com.perfil.api.dto.ProdutoDTO;
import com.perfil.api.dto.ResultadoSimulacaoDTO;
import com.perfil.api.dto.SimulacaoRequestDTO;
import com.perfil.api.dto.SimulacaoResponseDTO;
import com.perfil.api.service.SimulacaoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SimulacaoController.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
class SimulacaoControllerUnifiedTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SimulacaoService simulacaoService;

    @TestConfiguration
    static class SimulacaoServiceTestConfig {
        @Bean
        public SimulacaoService simulacaoService() {
            return Mockito.mock(SimulacaoService.class);
        }
    }

    @Test
    @WithMockUser(username = "teste", roles = {"USER"}) // ✅ Simula usuário autenticado
    void deveSimularInvestimentoComSucesso() throws Exception {
        // ✅ Monta resposta mockada
        ProdutoDTO produto = new ProdutoDTO();
        produto.setTipo("CDB");

        ResultadoSimulacaoDTO resultado = new ResultadoSimulacaoDTO();
        resultado.setPrazoMeses(12);
        resultado.setValorFinal(1500.0);

        SimulacaoResponseDTO response = new SimulacaoResponseDTO();
        response.setProdutoValidado(produto);
        response.setResultadoSimulacao(resultado);
        response.setDataSimulacao(LocalDateTime.now());

        Mockito.when(simulacaoService.simularInvestimento(Mockito.any()))
                .thenReturn(response);

        // ✅ Monta request
        SimulacaoRequestDTO request = new SimulacaoRequestDTO();
        request.setClienteId(1L);
        request.setValor(1000.0);
        request.setPrazoMeses(12);
        request.setTipoProduto("CDB");

        // ✅ Executa teste
        mockMvc.perform(post("/simular-investimento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.produtoValidado.tipo").value("CDB"))
                .andExpect(jsonPath("$.resultadoSimulacao.prazoMeses").value(12))
                .andExpect(jsonPath("$.resultadoSimulacao.valorFinal").value(1500.0))
                .andExpect(jsonPath("$.dataSimulacao").exists());
    }
}
