package com.perfil.api.controller;

import com.perfil.api.dto.ProdutoDTO;
import com.perfil.api.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RestController
@RequestMapping("/produtos-recomendados")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/{perfil}")
    public Page<ProdutoDTO> listarPorPerfil(@PathVariable String perfil,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return produtoService.listarPorPerfil(perfil, pageable);
    }
}