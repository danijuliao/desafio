-- CLIENTES
INSERT INTO clientes (id, nome, cpf, email, telefone, preferencia_liquidez, preferencia_rentabilidade)
VALUES
(1, 'Cliente Teste', '12345678900', 'teste@teste.com', '11999999999', 'true', 'false'),
(2, 'Cliente Moderado', '98765432100', 'moderado@teste.com', '11988888888', 'false', 'true'),
(3, 'Cliente Agressivo', '11122233344', 'agressivo@teste.com', '11977777777', 'false', 'true');

-- PERFIS DE RISCO
INSERT INTO perfis_risco (id, cliente_id, perfil, pontuacao, descricao)
VALUES
(1, 1, 'Conservador', 40, 'Foco em liquidez e segurança.'),
(2, 2, 'Moderado', 65, 'Equilíbrio entre segurança e rentabilidade.'),
(3, 3, 'Agressivo', 90, 'Busca por alta rentabilidade e maior risco.');

-- PRODUTOS
INSERT INTO produtos (id, nome, tipo, rentabilidade, risco)
VALUES
(1, 'CDB Caixa 2026', 'CDB', 0.12, 'Baixo'),
(2, 'Fundo XPTO', 'Fundo', 0.18, 'Alto'),
(3, 'Tesouro Selic 2029', 'Tesouro Direto', 0.10, 'Baixo'),
(4, 'LCI Imobiliária', 'LCI', 0.11, 'Médio');

-- SIMULAÇÕES
INSERT INTO simulacoes (id, cliente_id, produto, valor_investido, valor_final, prazo_meses, data_simulacao)
VALUES
(1, 1, 'CDB Caixa 2026', 10000.00, 11200.00, 12, '2025-11-19'),
(2, 2, 'Fundo XPTO', 5000.00, 5900.00, 6, '2025-11-18'),
(3, 3, 'LCI Imobiliária', 20000.00, 22200.00, 12, '2025-11-17');


-- INVESTIMENTOS
INSERT INTO investimentos (id, cliente_id, tipo, valor, rentabilidade, data)
VALUES
(1, 1, 'CDB', 5000.00, 0.12, '2025-01-15'),
(2, 2, 'Fundo Multimercado', 3000.00, 0.08, '2025-03-10'),
(3, 3, 'LCI', 15000.00, 0.11, '2025-02-20');

-- TELEMETRIA
INSERT INTO telemetria (id, servico, quantidade_chamadas, media_tempo_resposta_ms, periodo_inicio, periodo_fim)
VALUES
(1, 'simular-investimento', 120, 250, '2025-10-01', '2025-10-31'),
(2, 'perfil-risco', 80, 180, '2025-10-01', '2025-10-31');