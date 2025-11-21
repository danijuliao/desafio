package com.perfil.api;

import com.perfil.api.dto.SimulacaoRequestDTO;
import com.perfil.api.repository.SimulacaoRepository;
import com.perfil.api.service.SimulacaoService;
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
public class PersistenciaSimulacaoTest {

    @Autowired
    private SimulacaoRepository simulacaoRepository;

    @Autowired
    private SimulacaoService simulacaoService;

    @Test
    void devePersistirSimulacaoNoBanco() {
        long countAntes = simulacaoRepository.count();

        // Cria o DTO com dados válidos
        SimulacaoRequestDTO request = new SimulacaoRequestDTO();
        request.setClienteId(1L);
        request.setValor(10000.00);
        request.setTipoProduto("CDB");
        request.setPrazoMeses(12);

        // Chama o serviço para persistir a simulação
        simulacaoService.simularInvestimento(request);

        long countDepois = simulacaoRepository.count();
        assertThat(countDepois).isGreaterThan(countAntes);
    }
}