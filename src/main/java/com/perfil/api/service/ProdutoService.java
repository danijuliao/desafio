package com.perfil.api.service;

import com.perfil.api.dto.ProdutoDTO;
import com.perfil.api.model.Produto;
import com.perfil.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<ProdutoDTO> listarPorPerfil(String perfil, Pageable pageable) {
        List<String> riscos;

        switch (perfil.toLowerCase()) {
            case "conservador":
                riscos = List.of("Baixo");
                break;
            case "moderado":
                riscos = List.of("Baixo", "Médio");
                break;
            case "agressivo":
                riscos = List.of("Médio", "Alto");
                break;
            default:
                throw new IllegalArgumentException("Perfil inválido: " + perfil);
        }

        Page<Produto> produtosPage = produtoRepository.findByRiscoIn(riscos, pageable);

        return produtosPage.map(p -> {
            ProdutoDTO dto = new ProdutoDTO();
            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setTipo(p.getTipo());
            dto.setRentabilidade(p.getRentabilidade());
            dto.setRisco(p.getRisco());
            return dto;
        });
    }
}
