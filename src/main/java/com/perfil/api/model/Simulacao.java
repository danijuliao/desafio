package com.perfil.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "simulacoes")
public class Simulacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String produto;
    private Double valorInvestido;
    private Double valorFinal;
    private Integer prazoMeses;
    private LocalDateTime dataSimulacao;

    public Simulacao() {}

    // ✅ Getters e Setters
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public String getProduto() { return produto; }
    public Double getValorInvestido() { return valorInvestido; }
    public Double getValorFinal() { return valorFinal; }
    public Integer getPrazoMeses() { return prazoMeses; }
    public LocalDateTime getDataSimulacao() { return dataSimulacao; }

    public void setId(Long id) { this.id = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setProduto(String produto) { this.produto = produto; }
    public void setValorInvestido(Double valorInvestido) { this.valorInvestido = valorInvestido; }
    public void setValorFinal(Double valorFinal) { this.valorFinal = valorFinal; }
    public void setPrazoMeses(Integer prazoMeses) { this.prazoMeses = prazoMeses; }
    public void setDataSimulacao(LocalDateTime dataSimulacao) { this.dataSimulacao = dataSimulacao; }
}
