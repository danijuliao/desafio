package com.perfil.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "investimentos")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false) // chave estrangeira
    private Cliente cliente;

    private String tipo;
    private Double valor;
    private Double rentabilidade;
    private LocalDate data;

    public Investimento() {}

    public Investimento(Long id, Cliente cliente, String tipo, Double valor, Double rentabilidade, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.valor = valor;
        this.rentabilidade = rentabilidade;
        this.data = data;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public String getTipo() { return tipo; }
    public Double getValor() { return valor; }
    public Double getRentabilidade() { return rentabilidade; }
    public LocalDate getData() { return data; }

    public void setId(Long id) { this.id = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setValor(Double valor) { this.valor = valor; }
    public void setRentabilidade(Double rentabilidade) { this.rentabilidade = rentabilidade; }
    public void setData(LocalDate data) { this.data = data; }
}
