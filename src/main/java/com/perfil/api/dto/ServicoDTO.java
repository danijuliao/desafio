package com.perfil.api.dto;

public class ServicoDTO {
    private String nome;
    private Integer quantidadeChamadas;
    private Long mediaTempoRespostaMs;
    public String getNome() {
        return nome;
    }
    public Integer getQuantidadeChamadas() {
        return quantidadeChamadas;
    }
    public Long getMediaTempoRespostaMs() {
        return mediaTempoRespostaMs;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQuantidadeChamadas(Integer quantidadeChamadas) {
        this.quantidadeChamadas = quantidadeChamadas;
    }
    public void setMediaTempoRespostaMs(Long mediaTempoRespostaMs) {
        this.mediaTempoRespostaMs = mediaTempoRespostaMs;
    }

    
}