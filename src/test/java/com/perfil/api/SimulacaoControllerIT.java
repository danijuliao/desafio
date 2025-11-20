package com.perfil.api;

import com.perfil.api.dto.ResultadoSimulacaoDTO;
import com.perfil.api.dto.SimulacaoRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class SimulacaoControllerIT {

@Autowired
@SuppressWarnings("unused")
private TestRestTemplate restTemplate;

@Test
void deveSimularInvestimentoComSucesso() {
    SimulacaoRequestDTO request = new SimulacaoRequestDTO();
    request.setClienteId(1L);
    request.setValor(1000.0);
    request.setPrazoMeses(12);
    request.setTipoProduto("CDB");


    ResponseEntity<ResultadoSimulacaoDTO> resposta = restTemplate.postForEntity(
            "/simulacoes/simular",
            request,
            ResultadoSimulacaoDTO.class
    );


    // Validações
    assertThat(resposta.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(resposta.getBody()).isNotNull();
    assertThat(resposta.getBody().getValorFinal())
            .isCloseTo(1100.0, org.assertj.core.data.Offset.offset(0.001));
}
}