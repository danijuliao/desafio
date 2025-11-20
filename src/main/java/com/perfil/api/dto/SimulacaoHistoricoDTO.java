package com.perfil.api.dto;

import java.time.LocalDateTime;

public class SimulacaoHistoricoDTO {
    private Long id;
    private Long cliente;
    private String produto;
    private Double valorInvestido;
    private Double valorFinal;
    private Integer prazoMeses;
    private LocalDateTime dataSimulacao;
    public Long getId() {
        return id;
    }
    public Long getClienteId() {
        return cliente;
    }
    public String getProduto() {
        return produto;
    }
    public Double getValorInvestido() {
        return valorInvestido;
    }
    public Double getValorFinal() {
        return valorFinal;
    }
    public Integer getPrazoMeses() {
        return prazoMeses;
    }
    public LocalDateTime getDataSimulacao() {
        return dataSimulacao;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCliente(Long clienteId) {
        this.cliente = clienteId;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }
    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
    public void setPrazoMeses(Integer prazoMeses) {
        this.prazoMeses = prazoMeses;
    }
    public void setDataSimulacao(LocalDateTime dataSimulacao) {
        this.dataSimulacao = dataSimulacao;
    }

    
    
}