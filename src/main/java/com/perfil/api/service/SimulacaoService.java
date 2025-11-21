package com.perfil.api.service;

import com.perfil.api.dto.*;
import com.perfil.api.exception.ClienteNaoEncontradoException;
import com.perfil.api.model.*;
import com.perfil.api.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class SimulacaoService {

    private final ClienteRepository clienteRepository;

    private final ProdutoRepository produtoRepository;
    private final SimulacaoRepository simulacaoRepository;

    public SimulacaoService(
            ClienteRepository clienteRepository,
            ProdutoRepository produtoRepository,
            SimulacaoRepository simulacaoRepository
    ) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.simulacaoRepository = simulacaoRepository;
    }

    public SimulacaoResponseDTO simularInvestimento(SimulacaoRequestDTO request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));

        PerfilRisco perfil = cliente.getPerfilRisco();
        Produto produtoRecomendado = produtoRepository.findFirstByTipoIgnoreCase(request.getTipoProduto())
                .orElseThrow(() -> new RuntimeException("Nenhum produto compatível encontrado"));

        double valorFinal = calcularValorFinal(request.getValor(), produtoRecomendado.getRentabilidade(), request.getPrazoMeses());
        double imposto = calcularImposto(valorFinal - request.getValor(), request.getPrazoMeses());
        double valorLiquido = valorFinal - imposto;

        Simulacao simulacao = new Simulacao();
        simulacao.setCliente(cliente);
        simulacao.setProduto(produtoRecomendado.getNome());
        simulacao.setValorInvestido(request.getValor());
        simulacao.setValorFinal(valorFinal);
        simulacao.setPrazoMeses(request.getPrazoMeses());
        simulacao.setDataSimulacao(LocalDateTime.now());

        simulacaoRepository.save(simulacao);

        ResultadoSimulacaoDTO resultado = new ResultadoSimulacaoDTO();
        resultado.setValorFinal(valorFinal);
        resultado.setRentabilidadeEfetiva(produtoRecomendado.getRentabilidade());
        resultado.setPrazoMeses(request.getPrazoMeses());

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoRecomendado.getId());
        produtoDTO.setNome(produtoRecomendado.getNome());
        produtoDTO.setTipo(produtoRecomendado.getTipo());
        produtoDTO.setRentabilidade(produtoRecomendado.getRentabilidade());
        produtoDTO.setRisco(produtoRecomendado.getRisco());

        SimulacaoResponseDTO response = new SimulacaoResponseDTO();
        response.setProdutoValidado(produtoDTO);
        response.setResultadoSimulacao(resultado);
        response.setDataSimulacao(simulacao.getDataSimulacao());

        return response;
    }

    private double calcularValorFinal(double valor, double taxa, int meses) {
        return valor * Math.pow(1 + taxa, meses / 12.0);
    }

    private double calcularImposto(double lucro, int meses) {
        if (meses <= 6) return lucro * 0.225;
        if (meses <= 12) return lucro * 0.20;
        if (meses <= 24) return lucro * 0.175;
        return lucro * 0.15;
    }

    public List<SimulacaoHistoricoDTO> listarHistorico(Long clienteId) {
    List<Simulacao> simulacoes = simulacaoRepository.findByClienteId(clienteId);

    return simulacoes.stream().map(s -> {
        SimulacaoHistoricoDTO dto = new SimulacaoHistoricoDTO();
        dto.setId(s.getId());
        dto.setCliente(s.getCliente().getId());
        dto.setProduto(s.getProduto());
        dto.setValorInvestido(s.getValorInvestido());
        dto.setValorFinal(s.getValorFinal());
        dto.setPrazoMeses(s.getPrazoMeses());
        dto.setDataSimulacao(s.getDataSimulacao());
        return dto;
    }).toList();
    }
}