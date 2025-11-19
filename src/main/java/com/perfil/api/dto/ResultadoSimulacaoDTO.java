package com.perfil.api.dto;

public class ResultadoSimulacaoDTO {
    private Double valorFinal;
    private Double rentabilidadeEfetiva;
    private Integer prazoMeses;
    
    public Double getValorFinal() {
        return valorFinal;
    }
    public Double getRentabilidadeEfetiva() {
        return rentabilidadeEfetiva;
    }
    public Integer getPrazoMeses() {
        return prazoMeses;
    }
    
    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
    public void setRentabilidadeEfetiva(Double rentabilidadeEfetiva) {
        this.rentabilidadeEfetiva = rentabilidadeEfetiva;
    }
    public void setPrazoMeses(Integer prazoMeses) {
        this.prazoMeses = prazoMeses;
    }


}