package com.perfil.api;

import com.perfil.api.dto.SimulacaoRequestDTO;
import com.perfil.api.dto.SimulacaoResponseDTO;
import com.perfil.api.model.Cliente;
import com.perfil.api.model.Produto;
import com.perfil.api.repository.ClienteRepository;
import com.perfil.api.repository.ProdutoRepository;
import com.perfil.api.repository.SimulacaoRepository;
import com.perfil.api.service.SimulacaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SimulacaoServiceTest {

    @Mock
    private SimulacaoRepository simulacaoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private SimulacaoService simulacaoService;

    public SimulacaoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveSimularInvestimentoComSucesso() {

        SimulacaoRequestDTO request = new SimulacaoRequestDTO();
        request.setClienteId(1L);
        request.setValor(1000.0);
        request.setPrazoMeses(12);
        request.setTipoProduto("CDB");


        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente Teste");
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));


        Produto produto = new Produto();
        produto.setId(101L);
        produto.setNome("CDB Caixa 2026");
        produto.setTipo("CDB");
        produto.setRentabilidade(0.12);
        produto.setRisco("Baixo");

        when(produtoRepository.findByTipo("CDB")).thenReturn(List.of(produto));

        SimulacaoResponseDTO response = simulacaoService.simularInvestimento(request);

        assertThat(response).isNotNull();
        assertThat(response.getResultadoSimulacao()).isNotNull();
        assertThat(response.getResultadoSimulacao().getValorFinal()).isGreaterThan(1000.0);
        assertThat(response.getResultadoSimulacao().getPrazoMeses()).isEqualTo(12);

    }
}