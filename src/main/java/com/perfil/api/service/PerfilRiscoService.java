package com.perfil.api.service;

import com.perfil.api.dto.PerfilRiscoDTO;
import com.perfil.api.model.Cliente;
import com.perfil.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class PerfilRiscoService {

    private final ClienteRepository clienteRepository;

    public PerfilRiscoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public PerfilRiscoDTO consultarPerfil(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        var perfil = cliente.getPerfilRisco();

        PerfilRiscoDTO dto = new PerfilRiscoDTO();
        dto.setClienteId(cliente.getId());
        dto.setPerfil(perfil.getPerfil());
        dto.setPontuacao(perfil.getPontuacao());
        dto.setDescricao(perfil.getDescricao());

        return dto;
    }
}