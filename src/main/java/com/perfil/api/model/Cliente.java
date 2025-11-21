package com.perfil.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String preferenciaLiquidez;
    private String preferenciaRentabilidade;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private PerfilRisco perfilRisco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Investimento> investimentos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Simulacao> simulacoes;

    public Cliente() {}

    public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getPreferenciaLiquidez() { return preferenciaLiquidez; }
    public String getPreferenciaRentabilidade() { return preferenciaRentabilidade; }
    public PerfilRisco getPerfilRisco() { return perfilRisco; }
    public List<Investimento> getInvestimentos() { return investimentos; }
    public List<Simulacao> getSimulacoes() { return simulacoes; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setPreferenciaLiquidez(String preferenciaLiquidez) { this.preferenciaLiquidez = preferenciaLiquidez; }
    public void setPreferenciaRentabilidade(String preferenciaRentabilidade) { this.preferenciaRentabilidade = preferenciaRentabilidade; }
    public void setPerfilRisco(PerfilRisco perfilRisco) { this.perfilRisco = perfilRisco; }
    void acoes(List<Simulacao> simulacoes) { this.simulacoes = simulacoes; }
}