package com.perfil.api.controller;

import com.perfil.api.dto.SimulacaoHistoricoDTO;
import com.perfil.api.service.SimulacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoSimulacaoController {

    private final SimulacaoService simulacaoService;

    public HistoricoSimulacaoController(SimulacaoService simulacaoService) {
        this.simulacaoService = simulacaoService;
    }

    @GetMapping("/{clienteId}")
    public List<SimulacaoHistoricoDTO> listarHistorico(@PathVariable Long clienteId) {
        return simulacaoService.listarHistorico(clienteId);
    }
}