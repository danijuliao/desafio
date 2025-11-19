package com.perfil.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String preferenciaLiquidez; // Ex: "Alta", "Baixa", "Equilibrada"

    private String preferenciaRentabilidade; // Ex: "Alta", "Baixa", "Equilibrada"

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "perfil_risco_id", referencedColumnName = "clienteId")
    private PerfilRisco perfilRisco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Investimento> investimentos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Simulacao> simulacoes;

    public Cliente(Long id, String nome, PerfilRisco perfilRisco) {
    this.id = id;
    this.nome = nome;
    this.perfilRisco = perfilRisco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getPreferenciaLiquidez() {
        return preferenciaLiquidez;
    }

    public String getPreferenciaRentabilidade() {
        return preferenciaRentabilidade;
    }

    public PerfilRisco getPerfilRisco() {
        return perfilRisco;
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public List<Simulacao> getSimulacoes() {
        return simulacoes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPreferenciaLiquidez(String preferenciaLiquidez) {
        this.preferenciaLiquidez = preferenciaLiquidez;
    }

    public void setPreferenciaRentabilidade(String preferenciaRentabilidade) {
        this.preferenciaRentabilidade = preferenciaRentabilidade;
    }

    public void setPerfilRisco(PerfilRisco perfilRisco) {
        this.perfilRisco = perfilRisco;
    }

    public void setInvestimentos(List<Investimento> investimentos) {
        this.investimentos = investimentos;
    }

    public void setSimulacoes(List<Simulacao> simulacoes) {
        this.simulacoes = simulacoes;
    }

    
}
