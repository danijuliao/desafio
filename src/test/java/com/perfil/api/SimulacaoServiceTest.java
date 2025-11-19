package com.perfil.api;

import com.perfil.api.dto.ResultadoSimulacaoDTO;
import com.perfil.api.repository.SimulacaoRepository;
import com.perfil.api.service.SimulacaoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class SimulacaoServiceTest {

    @Mock
    private SimulacaoRepository simulacaoRepository;

    @InjectMocks
    private SimulacaoService simulacaoService;

    public SimulacaoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveSimularInvestimentoComSucesso() {
        ResultadoSimulacaoDTO resultado = simulacaoService.simularInvestimento(1000.0, 0.1, 12);

        assertNotNull(resultado);
        assertEquals(1100.0, resultado.getValorFinal());
        assertEquals(0.1, resultado.getRentabilidadeEfetiva());
        assertEquals(12, resultado.getPrazoMeses());
    }
}