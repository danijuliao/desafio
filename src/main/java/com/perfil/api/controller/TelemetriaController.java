package com.perfil.api.controller;

import com.perfil.api.dto.TelemetriaDTO;
import com.perfil.api.service.TelemetriaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telemetria")
public class TelemetriaController {

    private final TelemetriaService telemetriaService;

    public TelemetriaController(TelemetriaService telemetriaService) {
        this.telemetriaService = telemetriaService;
    }

    @GetMapping
    public TelemetriaDTO consultarTelemetria() {
        return telemetriaService.consultarTelemetria();
    }
}