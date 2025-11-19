package com.perfil.api;

import com.perfil.api.dto.TelemetriaDTO;
import com.perfil.api.model.Telemetria;
import com.perfil.api.repository.TelemetriaRepository;
import com.perfil.api.service.TelemetriaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TelemetriaServiceTest {

    @Mock
    private TelemetriaRepository telemetriaRepository;

    @InjectMocks
    private TelemetriaService telemetriaService;

    public TelemetriaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveConsultarTelemetriaComSucesso() {
        Telemetria t1 = new Telemetria(1L, "servicoA", 10, 200L, "2025-01-01", "2025-01-31", LocalDateTime.now().minusDays(2));
        Telemetria t2 = new Telemetria(2L, "servicoA", 15, 300L, "2025-01-01", "2025-01-31", LocalDateTime.now());

        when(telemetriaRepository.findAll()).thenReturn(List.of(t1, t2));

        TelemetriaDTO dto = telemetriaService.consultarTelemetria();

        assertNotNull(dto);
        assertEquals(1, dto.getServicos().size());
        assertEquals("servicoA", dto.getServicos().get(0).getNome());
        assertEquals(2, dto.getServicos().get(0).getQuantidadeChamadas());
    }
}