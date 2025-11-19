package com.perfil.api.repository;

import com.perfil.api.model.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SimulacaoRepository extends JpaRepository<Simulacao, Long> {
    List<Simulacao> findByClienteId(Long clienteId);
    List<Simulacao> findByProdutoAndDataSimulacaoBetween(String produto, LocalDateTime inicio, LocalDateTime fim);
}