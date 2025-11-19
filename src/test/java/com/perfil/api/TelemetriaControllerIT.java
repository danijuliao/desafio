package com.perfil.api;

import com.perfil.api.dto.TelemetriaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TelemetriaControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void deveRetornarTelemetria() {
        ResponseEntity<TelemetriaDTO> resposta = restTemplate.getForEntity("/telemetria", TelemetriaDTO.class);

        assertThat(resposta.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(resposta.getBody()).isNotNull();
        assertThat(resposta.getBody().getServicos()).isNotEmpty();
    }
}