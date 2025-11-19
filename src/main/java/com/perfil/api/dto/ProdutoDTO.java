package com.perfil.api.dto;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private String tipo;
    private Double rentabilidade;
    private String risco;
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public Double getRentabilidade() {
        return rentabilidade;
    }
    public String getRisco() {
        return risco;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setRentabilidade(Double rentabilidade) {
        this.rentabilidade = rentabilidade;
    }
    public void setRisco(String risco) {
        this.risco = risco;
    }
}