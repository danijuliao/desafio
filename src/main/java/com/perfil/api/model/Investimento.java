package com.perfil.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "investimentos")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    private String tipo;

    private Double valor;

    private Double rentabilidade;

    private LocalDate data;

    public Investimento(Long id, Long clienteId, String tipo, Double valor, Double rentabilidade, LocalDate data) {
    this.id = id;
    this.clienteId = clienteId;
    this.tipo = tipo;
    this.valor = valor;
    this.rentabilidade = rentabilidade;
    this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
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

    public LocalDate getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    
}