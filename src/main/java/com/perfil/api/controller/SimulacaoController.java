package com.perfil.api.controller;

import com.perfil.api.dto.SimulacaoHistoricoDTO;
import com.perfil.api.dto.SimulacaoRequestDTO;
import com.perfil.api.dto.SimulacaoResponseDTO;
import com.perfil.api.service.SimulacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class    SimulacaoController {

    private final SimulacaoService simulacaoService;

    public SimulacaoController(SimulacaoService simulacaoService) {

        this.simulacaoService = simulacaoService;
    }

    @PostMapping("/simular-investimento")
    public ResponseEntity<?> simular(@Valid @RequestBody SimulacaoRequestDTO request) {
        // Validação: clienteId obrigatório
        if (request.getClienteId() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente não encontrado");
        }

        // Validação: prazo deve ser maior que zero
        if (request.getPrazoMeses() == null || request.getPrazoMeses() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Prazo inválido");
        }

        // Se passou nas validações, chama o serviço
        SimulacaoResponseDTO resultado = simulacaoService.simularInvestimento(request);
        return ResponseEntity.ok(resultado);

    }

    @GetMapping("/simulacoes")
    public ResponseEntity<List<SimulacaoHistoricoDTO>> listarHistorico(@RequestParam Long clienteId) {
        return ResponseEntity.ok(simulacaoService.listarHistorico(clienteId));
    }

}