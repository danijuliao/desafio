package com.perfil.api.dto;

import java.time.LocalDateTime;

public class SimulacaoResponseDTO {
    private ProdutoDTO produtoValidado;
    private ResultadoSimulacaoDTO resultadoSimulacao;
    private LocalDateTime dataSimulacao;
    public ProdutoDTO getProdutoValidado() {
        return produtoValidado;
    }
    public ResultadoSimulacaoDTO getResultadoSimulacao() {
        return resultadoSimulacao;
    }
    public LocalDateTime getDataSimulacao() {
        return dataSimulacao;
    }
    public void setProdutoValidado(ProdutoDTO produtoValidado) {
        this.produtoValidado = produtoValidado;
    }
    public void setResultadoSimulacao(ResultadoSimulacaoDTO resultadoSimulacao) {
        this.resultadoSimulacao = resultadoSimulacao;
    }
    public void setDataSimulacao(LocalDateTime dataSimulacao) {
        this.dataSimulacao = dataSimulacao;
    }

    
}