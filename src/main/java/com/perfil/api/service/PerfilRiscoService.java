package com.perfil.api.service;

import com.perfil.api.dto.PerfilRiscoDTO;
import com.perfil.api.model.Investimento;
import com.perfil.api.repository.InvestimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilRiscoService {

    private final InvestimentoRepository investimentoRepository;

    public PerfilRiscoService(InvestimentoRepository investimentoRepository) {
        this.investimentoRepository = investimentoRepository;
    }

    public PerfilRiscoDTO calcularPerfil(Long clienteId) {
        // Buscar histórico de investimentos do cliente
        List<Investimento> investimentos = investimentoRepository.findByClienteId(clienteId);

        double volumeTotal = investimentos.stream()
                .mapToDouble(Investimento::getValor)
                .sum();

        int frequencia = investimentos.size();

        // Inferir preferência: se maioria dos produtos tem rentabilidade alta, assume rentabilidade
        long produtosRentaveis = investimentos.stream()
                .filter(inv -> inv.getRentabilidade() >= 0.12) // exemplo: acima de 12% ao ano
                .count();

        String preferencia = (produtosRentaveis > frequencia / 2) ? "rentabilidade" : "liquidez";

        // Calcular pontuação
        int pontuacao = 0;
        if (volumeTotal < 10000) {
            pontuacao += 10;
        } else if (volumeTotal < 50000) {
            pontuacao += 30;
        } else {
            pontuacao += 50;
        }

        if (frequencia < 5) {
            pontuacao += 10;
        } else if (frequencia < 20) {
            pontuacao += 20;
        } else {
            pontuacao += 30;
        }

        if ("liquidez".equalsIgnoreCase(preferencia)) {
            pontuacao += 10;
        } else {
            pontuacao += 20;
        }

        // Determinar perfil
        String perfil;
        if (pontuacao <= 40) {
            perfil = "Conservador";
        } else if (pontuacao <= 70) {
            perfil = "Moderado";
        } else {
            perfil = "Agressivo";
        }

        // Montar DTO
        PerfilRiscoDTO dto = new PerfilRiscoDTO();
        dto.setClienteId(clienteId);
        dto.setPerfil(perfil);
        dto.setPontuacao(pontuacao);
        dto.setDescricao("Perfil baseado em volume, frequência e preferência.");

        return dto;
    }
}