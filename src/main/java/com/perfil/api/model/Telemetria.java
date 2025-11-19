package com.perfil.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "telemetria")
public class Telemetria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeServico;
    private Integer quantidadeChamadas;
    private Long mediaTempoRespostaMs;
    private String periodoInicio;
    private String periodoFim;
    private LocalDateTime dataHora;

    public Telemetria() {}

    public Telemetria(Long id, String nomeServico, Integer quantidadeChamadas, Long mediaTempoRespostaMs,
                      String periodoInicio, String periodoFim, LocalDateTime dataHora) {
        this.id = id;
        this.nomeServico = nomeServico;
        this.quantidadeChamadas = quantidadeChamadas;
        this.mediaTempoRespostaMs = mediaTempoRespostaMs;
        this.periodoInicio = periodoInicio;
        this.periodoFim = periodoFim;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public Integer getQuantidadeChamadas() {
        return quantidadeChamadas;
    }

    public Long getMediaTempoRespostaMs() {
        return mediaTempoRespostaMs;
    }

    public String getPeriodoInicio() {
        return periodoInicio;
    }

    public String getPeriodoFim() {
        return periodoFim;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public void setQuantidadeChamadas(Integer quantidadeChamadas) {
        this.quantidadeChamadas = quantidadeChamadas;
    }

    public void setMediaTempoRespostaMs(Long mediaTempoRespostaMs) {
        this.mediaTempoRespostaMs = mediaTempoRespostaMs;
    }

    public void setPeriodoInicio(String periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public void setPeriodoFim(String periodoFim) {
        this.periodoFim = periodoFim;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}