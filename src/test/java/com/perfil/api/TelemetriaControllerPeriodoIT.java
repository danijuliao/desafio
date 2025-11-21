package com.perfil.api;

import com.perfil.api.dto.TelemetriaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TelemetriaControllerPeriodoIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void deveFiltrarTelemetriaPorPeriodo() {
        ResponseEntity<TelemetriaDTO> resposta = restTemplate.getForEntity("/telemetria?inicio=2025-01-01&fim=2025-01-31", TelemetriaDTO.class);

        assertThat(resposta.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(resposta.getBody()).isNotNull();
        assertThat(resposta.getBody().getServicos()).isNotEmpty();

        // Valida que período retornado corresponde ao filtro
        assertThat(resposta.getBody().getPeriodo().getInicio()).isEqualTo("2025-01-01");
        assertThat(resposta.getBody().getPeriodo().getFim()).isEqualTo("2025-01-31");
    }
}