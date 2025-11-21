package com.perfil.api.service;

import com.perfil.api.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacaoService {

    public List<Produto> recomendarPorPerfil(String perfil) {
        if ("Moderado".equalsIgnoreCase(perfil)) {
            return List.of(
                    new Produto(null, "CDB", "Renda Fixa", 0.12, "Baixo"),
                    new Produto(null, "Fundo Multimercado", "Fundo", 0.18, "Médio")
            );
        } else if ("Conservador".equalsIgnoreCase(perfil)) {
            return List.of(
                    new Produto(null, "Tesouro Selic", "Renda Fixa", 0.10, "Baixo")
            );
        } else {
            return List.of(
                    new Produto(null, "Ações", "Renda Variável", 0.25, "Alto")
            );
        }
    }
}