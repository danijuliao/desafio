package com.perfil.api.service;

import com.perfil.api.dto.ProdutoDTO;
import com.perfil.api.model.Produto;
import com.perfil.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDTO> listarPorPerfil(String perfil) {
        List<Produto> produtos = produtoRepository.findByRisco(perfil);

        return produtos.stream().map(p -> {
            ProdutoDTO dto = new ProdutoDTO();
            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setTipo(p.getTipo());
            dto.setRentabilidade(p.getRentabilidade());
            dto.setRisco(p.getRisco());
            return dto;
        }).toList();
    }
}