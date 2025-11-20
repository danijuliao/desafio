package com.perfil.api.repository;

import com.perfil.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Page<Produto> findByRiscoIn(List<String> riscos, Pageable pageable);
    List<Produto> findByTipo(String tipo);
}