package com.perfil.api.repository;

import com.perfil.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByTipo(String tipo);
    List<Produto> findByRisco(String risco);
}