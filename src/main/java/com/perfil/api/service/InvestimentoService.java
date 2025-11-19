package com.perfil.api.service;

import com.perfil.api.dto.InvestimentoDTO;
import com.perfil.api.repository.InvestimentoRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class InvestimentoService {

    private final InvestimentoRepository investimentoRepository;

    public InvestimentoService(InvestimentoRepository investimentoRepository) {
        this.investimentoRepository = investimentoRepository;
    }

    public List<InvestimentoDTO> listarPorCliente(Long clienteId) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return investimentoRepository.findByClienteId(clienteId).stream().map(investimento -> {
            var dto = new InvestimentoDTO();
            dto.setId(investimento.getId());
            dto.setTipo(investimento.getTipo());
            dto.setValor(investimento.getValor());
            dto.setRentabilidade(investimento.getRentabilidade());
            dto.setData(investimento.getData().format(formatter));
            return dto;
        }).toList();
    }
}