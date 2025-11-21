package com.perfil.api.service;

import com.perfil.api.model.Telemetria;
import com.perfil.api.dto.*;
import com.perfil.api.repository.TelemetriaRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    public TelemetriaDTO consultarTelemetria(String inicio, String fim) {
        // Converte as datas recebidas (formato esperado: yyyy-MM-dd)
        LocalDateTime dataInicio = LocalDateTime.parse(inicio + "T00:00:00");
        LocalDateTime dataFim = LocalDateTime.parse(fim + "T23:59:59");

        // Filtra os registros pelo intervalo
        var registros = telemetriaRepository.findAll().stream()
                .filter(t -> !t.getDataHora().isBefore(dataInicio) && !t.getDataHora().isAfter(dataFim))
                .toList();

        // Agrupa por nome do serviço e calcula métricas
        List<ServicoDTO> servicos = registros.stream()
                .collect(Collectors.groupingBy(
                        Telemetria::getNomeServico,
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

        // Monta o período com os parâmetros recebidos
        PeriodoDTO periodo = new PeriodoDTO();
        periodo.setInicio(inicio);
        periodo.setFim(fim);

        // Monta o DTO final
        TelemetriaDTO dto = new TelemetriaDTO();
        dto.setServicos(servicos);
        dto.setPeriodo(periodo);

        return dto;
    }

    public Map<String, Object> consultarTelemetriaDetalhada() {
        var registros = telemetriaRepository.findAll();

        List<Map<String, Object>> servicos = registros.stream()
                .collect(Collectors.groupingBy(
                        Telemetria::getNomeServico,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                lista -> {
                                        Map<String, Object> map = new HashMap<>();
                                        map.put("nome", lista.get(0).getNomeServico());
                                        map.put("quantidadeChamadas", lista.size());
                                        map.put("mediaTempoRespostaMs", Math.round(lista.stream()
                                            .mapToLong(Telemetria::getMediaTempoRespostaMs)
                                                .average()
                                                .orElse(0)));
                                        return map;
                                }
                )
                        ))
                .values()
                .stream()
                .toList();

        String inicio = registros.isEmpty() ? null : registros.get(0).getPeriodoInicio();
        String fim = registros.isEmpty() ? null : registros.get(0).getPeriodoFim();

        Map<String, Object> periodo = new HashMap<>();
        periodo.put("inicio", inicio);
        periodo.put("fim", fim);

        Map<String, Object> response = new HashMap<>();
        response.put("servicos", servicos);
        response.put("periodo", periodo);

        return response;
    }

}