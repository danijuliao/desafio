CREATE TABLE clientes (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          nome NVARCHAR(255) NOT NULL,
                          cpf NVARCHAR(255),
                          email NVARCHAR(255),
                          telefone NVARCHAR(255),
                          preferencia_liquidez NVARCHAR(255),
                          preferencia_rentabilidade NVARCHAR(255),
                          perfil_risco NVARCHAR(255),
                          pontuacao INT
);

CREATE TABLE perfis_risco (
                              id INT IDENTITY(1,1) PRIMARY KEY,
                              cliente_id INT NOT NULL,
                              perfil NVARCHAR(255),
                              pontuacao INT,
                              descricao NVARCHAR(MAX),
                              FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE produtos (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          nome NVARCHAR(255) NOT NULL,
                          tipo NVARCHAR(255) NOT NULL,
                          rentabilidade REAL NOT NULL,
                          risco NVARCHAR(255) NOT NULL
);

CREATE TABLE simulacoes (
                            id INT IDENTITY(1,1) PRIMARY KEY,
                            cliente_id INT NOT NULL,
                            produto NVARCHAR(255) NOT NULL,
                            valor_investido REAL NOT NULL,
                            valor_final REAL NOT NULL,
                            prazo_meses INT NOT NULL,
                            data_simulacao NVARCHAR(255) NOT NULL,
                            FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE investimentos (
                               id INT IDENTITY(1,1) PRIMARY KEY,
                               cliente_id INT NOT NULL,
                               tipo NVARCHAR(255) NOT NULL,
                               valor REAL NOT NULL,
                               rentabilidade REAL NOT NULL,
                               data NVARCHAR(255) NOT NULL,
                               FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE telemetria (
                            id INT IDENTITY(1,1) PRIMARY KEY,
                            servico NVARCHAR(255) NOT NULL,
                            quantidade_chamadas INT NOT NULL,
                            media_tempo_resposta_ms INT NOT NULL,
                            periodo_inicio NVARCHAR(255) NOT NULL,
                            periodo_fim NVARCHAR(255) NOT NULL,
                            data_hora NVARCHAR(255)
);

CREATE INDEX idx_simulacao_cliente ON simulacoes(cliente_id);
CREATE INDEX idx_investimento_cliente ON investimentos(cliente_id);