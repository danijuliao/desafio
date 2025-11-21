package com.perfil.api.controller;

import com.perfil.api.dto.TelemetriaDTO;
import com.perfil.api.service.TelemetriaService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/telemetria")
public class TelemetriaController {

    private final TelemetriaService telemetriaService;

    public TelemetriaController(TelemetriaService telemetriaService) {
        this.telemetriaService = telemetriaService;
    }

    @GetMapping
    public TelemetriaDTO consultarTelemetria(@RequestParam String inicio, @RequestParam String fim) {
        return telemetriaService.consultarTelemetria(inicio, fim);
    }

    @GetMapping("/detalhada")
    public Map<String, Object> consultarTelemetriaDetalhada() {
        return telemetriaService.consultarTelemetriaDetalhada();
    }

}