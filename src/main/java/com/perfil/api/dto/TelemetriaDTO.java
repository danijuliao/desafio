package com.perfil.api.dto;

import java.util.List;

public class TelemetriaDTO {
    private List<ServicoDTO> servicos;
    private PeriodoDTO periodo;
    
    public List<ServicoDTO> getServicos() {
        return servicos;
    }
    public PeriodoDTO getPeriodo() {
        return periodo;
    }
    public void setServicos(List<ServicoDTO> servicos) {
        this.servicos = servicos;
    }
    public void setPeriodo(PeriodoDTO periodo) {
        this.periodo = periodo;
    }

    
}