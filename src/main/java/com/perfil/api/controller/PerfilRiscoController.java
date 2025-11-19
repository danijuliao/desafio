package com.perfil.api.controller;

import com.perfil.api.dto.PerfilRiscoDTO;
import com.perfil.api.service.PerfilRiscoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil-risco")
public class PerfilRiscoController {

    private final PerfilRiscoService perfilRiscoService;

    public PerfilRiscoController(PerfilRiscoService perfilRiscoService) {
        this.perfilRiscoService = perfilRiscoService;
    }

    @GetMapping("/{clienteId}")
    public PerfilRiscoDTO consultarPerfil(@PathVariable Long clienteId) {
        return perfilRiscoService.consultarPerfil(clienteId);
    }
}