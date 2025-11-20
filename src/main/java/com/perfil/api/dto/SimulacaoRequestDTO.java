package com.perfil.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SimulacaoRequestDTO {

    @NotNull
    private Long clienteId;
    @Positive
    private Double valor;
    @Positive private Integer prazoMeses;
    @NotNull private String tipoProduto;

    public Long getClienteId() {
        return clienteId;
    }
    public Double getValor() {
        return valor;
    }
    public Integer getPrazoMeses() {
        return prazoMeses;
    }
    public String getTipoProduto() {
        return tipoProduto;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public void setPrazoMeses(Integer prazoMeses) {
        this.prazoMeses = prazoMeses;
    }
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    
}