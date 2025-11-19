package com.perfil.api.dto;

public class PerfilRiscoDTO {
    private Long clienteId;
    private String perfil;
    private Integer pontuacao;
    private String descricao;
    
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