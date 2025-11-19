package com.perfil.api.dto;

public class SimulacaoPorProdutoDiaDTO {
    private String produto;
    private String data;
    private Integer quantidadeSimulacoes;
    private Double mediaValorFinal;

    public String getProduto() {
        return produto;
    }
    public String getData() {
        return data;
    }
    public Integer getQuantidadeSimulacoes() {
        return quantidadeSimulacoes;
    }
    public Double getMediaValorFinal() {
        return mediaValorFinal;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setQuantidadeSimulacoes(Integer quantidadeSimulacoes) {
        this.quantidadeSimulacoes = quantidadeSimulacoes;
    }
    public void setMediaValorFinal(Double mediaValorFinal) {
        this.mediaValorFinal = mediaValorFinal;
    }

    
}