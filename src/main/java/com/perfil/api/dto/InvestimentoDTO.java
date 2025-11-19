package com.perfil.api.dto;

public class InvestimentoDTO {
    private Long id;
    private String tipo;
    private Double valor;
    private Double rentabilidade;
    private String data;
    
    public Long getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public Double getValor() {
        return valor;
    }
    public Double getRentabilidade() {
        return rentabilidade;
    }
    public String getData() {
        return data;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public void setRentabilidade(Double rentabilidade) {
        this.rentabilidade = rentabilidade;
    }
    public void setData(String data) {
        this.data = data;
    }

    
}