package com.perfil.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "perfis_risco")
public class PerfilRisco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String perfil;
    private Integer pontuacao;
    private String descricao;

    public PerfilRisco() {}

    public PerfilRisco(Long id, Cliente cliente, String perfil, Integer pontuacao, String descricao) {
        this.id = id;
        this.cliente = cliente;
        this.perfil = perfil;
        this.pontuacao = pontuacao;
        this.descricao = descricao;
    }

    // ✅ Getters e Setters
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public String getPerfil() { return perfil; }
    public Integer getPontuacao() { return pontuacao; }
    public String getDescricao() { return descricao; }

    public void setId(Long id) { this.id = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setPerfil(String perfil) { this.perfil = perfil; }
    public void setPontuacao(Integer pontuacao) { this.pontuacao = pontuacao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}