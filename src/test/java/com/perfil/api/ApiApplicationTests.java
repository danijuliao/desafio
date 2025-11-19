package com.perfil.api;

import com.perfil.api.dto.ResultadoSimulacaoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class ApiApplicationTests {

	@Test
	void contextLoads() {
	}

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public static class SimulacaoControllerIT {

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void deveSimularInvestimentoComSucesso() {
            ResponseEntity<ResultadoSimulacaoDTO> resposta = restTemplate.getForEntity(
                    "/simulacoes/simular?valorInvestimento=1000.0&rentabilidadeAnual=0.1&prazoMeses=12",
                    ResultadoSimulacaoDTO.class);

            assertThat(resposta.getStatusCode().is2xxSuccessful()).isTrue();
            assertThat(resposta.getBody()).isNotNull();
            assertThat(resposta.getBody().getValorFinal()).isEqualTo(1100.0);
        }
    }
}
