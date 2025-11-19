package com.perfil.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "perfis_risco")
public class PerfilRisco {

    @Id
    private Long clienteId;

    private String perfil;

    private Integer pontuacao;

    private String descricao;

    public PerfilRisco(Long clienteId, String perfil, Integer pontuacao, String descricao) {
    this.clienteId = clienteId;
    this.perfil = perfil;
    this.pontuacao = pontuacao;
    this.descricao = descricao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getPerfil() {
        return perfil;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}