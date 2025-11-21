-- Tabela clientes
CREATE TABLE IF NOT EXISTS clientes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    cpf TEXT,
    email TEXT,
    telefone TEXT,
    preferencia_liquidez TEXT,
    preferencia_rentabilidade TEXT
);

-- Tabela perfis_risco
CREATE TABLE IF NOT EXISTS perfis_risco (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    cliente_id INTEGER NOT NULL,
    perfil TEXT,
    pontuacao INTEGER,
    descricao TEXT,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Tabela produtos
CREATE TABLE IF NOT EXISTS produtos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    tipo TEXT NOT NULL,
    rentabilidade REAL NOT NULL,
    risco TEXT NOT NULL
);

-- Tabela simulacoes
CREATE TABLE IF NOT EXISTS simulacoes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    cliente_id INTEGER NOT NULL,
    produto TEXT NOT NULL,
    valor_investido REAL NOT NULL,
    valor_final REAL NOT NULL,
    prazo_meses INTEGER NOT NULL,
    data_simulacao TEXT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Tabela investimentos
CREATE TABLE IF NOT EXISTS investimentos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    cliente_id INTEGER NOT NULL,
    tipo TEXT NOT NULL,
    valor REAL NOT NULL,
    rentabilidade REAL NOT NULL,
    data TEXT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Tabela telemetria
CREATE TABLE IF NOT EXISTS telemetria (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    servico TEXT NOT NULL,
    quantidade_chamadas INTEGER NOT NULL,
    media_tempo_resposta_ms INTEGER NOT NULL,
    periodo_inicio TEXT NOT NULL,
    periodo_fim TEXT NOT NULL,
    data_hora TEXT
);

-- Índices opcionais
CREATE INDEX IF NOT EXISTS idx_simulacao_cliente ON simulacoes(cliente_id);
CREATE INDEX IF NOT EXISTS idx_investimento_cliente ON investimentos(cliente_id);