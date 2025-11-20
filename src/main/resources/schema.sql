CREATE TABLE IF NOT EXISTS Cliente (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    perfil_risco TEXT,
    pontuacao INTEGER
);

CREATE TABLE IF NOT EXISTS Produto (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    tipo TEXT NOT NULL,
    rentabilidade REAL NOT NULL,
    risco TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Simulacao (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    cliente_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    valor_investido REAL NOT NULL,
    valor_final REAL NOT NULL,
    prazo_meses INTEGER NOT NULL,
    data_simulacao TEXT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);

CREATE TABLE IF NOT EXISTS Telemetria (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    servico TEXT NOT NULL,
    quantidade_chamadas INTEGER NOT NULL,
    media_tempo_resposta_ms INTEGER NOT NULL,
    periodo_inicio TEXT NOT NULL,
    periodo_fim TEXT NOT NULL
);