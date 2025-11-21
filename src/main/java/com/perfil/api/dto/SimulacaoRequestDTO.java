package com.perfil.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SimulacaoRequestDTO {

    @NotNull(message = "ClienteId é obrigatório")
    private Long clienteId;

    @NotNull(message = "Valor é obrigatório")
    @Min(value = 1, message = "Valor deve ser maior que zero")
    private Double valor;


    @NotNull(message = "Prazo é obrigatório")
    @Min(value = 1, message = "Prazo deve ser maior que zero")
    private Integer prazoMeses;

    @NotNull(message = "Tipo de produto é obrigatório")
    private String tipoProduto;

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