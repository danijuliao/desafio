package com.perfil.api;

import com.perfil.api.dto.TelemetriaDTO;
import com.perfil.api.model.Telemetria;
import com.perfil.api.repository.TelemetriaRepository;
import com.perfil.api.service.TelemetriaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TelemetriaServiceTest {

    @Mock
    private TelemetriaRepository telemetriaRepository;

    @InjectMocks
    private TelemetriaService telemetriaService;

    public TelemetriaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveConsultarTelemetriaComServicosAgrupadosEMediaCalculada() {
        Telemetria t1 = new Telemetria(1L, "simular-investimento", 10, 200L, "2025-01-01", "2025-01-31", LocalDateTime.now().minusDays(2));
        Telemetria t2 = new Telemetria(2L, "simular-investimento", 15, 300L, "2025-01-01", "2025-01-31", LocalDateTime.now());
        Telemetria t3 = new Telemetria(3L, "perfil-risco", 5, 150L, "2025-01-01", "2025-01-31", LocalDateTime.now());

        when(telemetriaRepository.findAll()).thenReturn(List.of(t1, t2, t3));

        TelemetriaDTO dto = telemetriaService.consultarTelemetria();

        assertNotNull(dto);
        assertEquals(2, dto.getServicos().size());

        var servicoSimular = dto.getServicos().stream().filter(s -> s.getNome().equals("simular-investimento")).findFirst().orElse(null);
        assertNotNull(servicoSimular);
        assertEquals(2, servicoSimular.getQuantidadeChamadas());
        assertTrue(servicoSimular.getMediaTempoRespostaMs() > 0);

        var servicoPerfil = dto.getServicos().stream().filter(s -> s.getNome().equals("perfil-risco")).findFirst().orElse(null);
        assertNotNull(servicoPerfil);
        assertEquals(1, servicoPerfil.getQuantidadeChamadas());
    }
}