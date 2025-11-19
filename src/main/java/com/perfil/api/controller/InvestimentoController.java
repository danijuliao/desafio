package com.perfil.api.controller;

import com.perfil.api.dto.InvestimentoDTO;
import com.perfil.api.service.InvestimentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    private final InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @GetMapping("/{clienteId}")
    public List<InvestimentoDTO> listarInvestimentos(@PathVariable Long clienteId) {
        return investimentoService.listarPorCliente(clienteId);
    }
}