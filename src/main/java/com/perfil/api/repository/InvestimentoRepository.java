package com.perfil.api.repository;

import com.perfil.api.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
    List<Investimento> findByClienteId(Long clienteId);
}