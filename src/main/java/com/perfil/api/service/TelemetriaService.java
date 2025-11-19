package com.perfil.api.service;

import com.perfil.api.model.Telemetria;
import com.perfil.api.dto.*;
import com.perfil.api.repository.TelemetriaRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

@Service
public class TelemetriaService {

    private final TelemetriaRepository telemetriaRepository;

    public TelemetriaService(TelemetriaRepository telemetriaRepository) {
        this.telemetriaRepository = telemetriaRepository;
    }

    public TelemetriaDTO consultarTelemetria() {
        var registros = telemetriaRepository.findAll();

        List<ServicoDTO> servicos = registros.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getNomeServico(),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                lista -> {
                                    var dto = new ServicoDTO();
                                    dto.setNome(lista.get(0).getNomeServico());
                                    dto.setQuantidadeChamadas(lista.size());
                                    dto.setMediaTempoRespostaMs(
                                            Math.round(lista.stream()
                                                    .mapToLong(Telemetria::getMediaTempoRespostaMs)
                                                    .average()
                                                    .orElse(0))
                                    );
                                    return dto;
                                }
                        )
                ))
                .values()
                .stream()
                .toList();

        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        PeriodoDTO periodo = new PeriodoDTO();
        periodo.setInicio(registros.stream()
                .map(Telemetria::getDataHora)
                .min(LocalDateTime::compareTo)
                .map(formatter::format)
                .orElse(null));

        periodo.setFim(registros.stream()
                .map(Telemetria::getDataHora)
                .max(LocalDateTime::compareTo)
                .map(formatter::format)
                .orElse(null));

        TelemetriaDTO dto = new TelemetriaDTO();
        dto.setServicos(servicos);
        dto.setPeriodo(periodo);

        return dto;
    }
}