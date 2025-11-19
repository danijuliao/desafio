package com.perfil.api.controller;

import com.perfil.api.dto.SimulacaoRequestDTO;
import com.perfil.api.dto.SimulacaoResponseDTO;
import com.perfil.api.service.SimulacaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulacoes")
public class SimulacaoController {

    private final SimulacaoService simulacaoService;

    public SimulacaoController(SimulacaoService simulacaoService) {
        this.simulacaoService = simulacaoService;
    }

    @PostMapping
    public SimulacaoResponseDTO simular(@RequestBody SimulacaoRequestDTO request) {
        return simulacaoService.simularInvestimento(request);
    }
}