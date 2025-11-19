package com.perfil.api.controller;

import com.perfil.api.dto.ProdutoDTO;
import com.perfil.api.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos-recomendados")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/{perfil}")
    public List<ProdutoDTO> listarPorPerfil(@PathVariable String perfil) {
        return produtoService.listarPorPerfil(perfil);
    }
}