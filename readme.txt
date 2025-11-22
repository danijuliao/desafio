Projeto desenvolvido para desafio de processo seletivo interno da Caixa

Painel de Investimentos com Perfil de Risco Dinâmico com objetivo de implementar uma API REST
em Java 21 com Spring Boot para simulação de investimentos, recomendação de produtos e análise de perfil de risco, conforme desafio proposto.

A aplicação:

Analisa comportamento financeiro do cliente.
Ajusta automaticamente o perfil de risco.
Sugere produtos de investimento (CDB, LCI, LCA, Tesouro Direto, Fundos).
Permite simulação de investimentos com cálculo de rentabilidade.
Persiste histórico de simulações e fornece telemetria.


Tecnologias Utilizadas

Java 21
Spring Boot 3.5.7
Spring Data JPA
Spring Security com JWT
SQLite como banco de dados
Hibernate
JUnit 5 e Mockito para testes
Docker (configuração pronta para container)


Estrutura do Projeto
src/
├── main/java/com/perfil/api
│    ├── controller      -> Endpoints REST
│    ├── dto             -> Objetos de transferência
│    ├── model           -> Entidades JPA
│    ├── repository      -> Repositórios JPA
│    ├── service         -> Regras de negócio
│    └── security        -> Configuração JWT
├── main/resources
│    ├── application.properties
│    ├── schema.sql
│    └── data.sql
└── test/java/com/perfil/api
-> Testes unitários e de integração

Como Rodar Localmente
Pré-requisitos:

Java 21 instalado
Maven instalado

Comandos:
mvn clean install
mvn spring-boot:run
A API estará disponível em:
http://localhost:8080

Como Rodar via Docker
Observação: Dockerfile e docker-compose.yml estão prontos, mas não testados neste ambiente.
Comandos:
docker build -t painel-investimentos .
docker run -p 8080:8080 painel-investimentos

Autenticação
Implementada via JWT.
Endpoints protegidos exigem token no header:
Authorization: Bearer

Endpoints Principais

Simular Investimento
POST /simular-investimento
Exemplo de Request:
{
"clienteId": 123,
"valor": 10000.00,
"prazoMeses": 12,
"tipoProduto": "CDB"
}

Exemplo de Response:
{
"produtoValidado": {
"id": 101,
"nome": "CDB Caixa 2026",
"tipo": "CDB",
"rentabilidade": 0.12,
"risco": "Baixo"
},
"resultadoSimulacao": {
"valorFinal": 11200.00,
"rentabilidadeEfetiva": 0.12,
"prazoMeses": 12
},
"dataSimulacao": "2025-10-31T14:00:00Z"
}


Histórico de Simulações
GET /simulacoes


Valores Simulados por Produto/Dia
GET /simulacoes/por-produto-dia


Telemetria
GET /telemetria


Perfil de Risco
GET /perfil-risco/{clienteId}


Produtos Recomendados
GET /produtos-recomendados/{perfil}



Testes

Unitários: Implementados com Mockito.
Integração: Implementados com Spring Boot Test.
Status atual: Ajustes no contexto SQLite em andamento. Próxima atualização corrigirá falhas no carregamento do ApplicationContext.


Evidências

Exemplos:

Simulação de investimento: simulacao.png
Histórico de simulações: historico.png


Próximos Passos

Corrigir configuração do SQLite para testes.
Garantir execução completa dos testes de integração.
Publicar imagem Docker funcional.

# Caminhos locais para configuração de versões
$env:JAVA_HOME = "C:\Users\c125762\tools\Java\jdk-21.0.9"
$env:MAVEN_HOME = "C:\Users\c125762\tools\apache-maven-3.9.11"
$env:PATH = "$env:JAVA_HOME\bin;$env:MAVEN_HOME\bin;$env:PATH"

#computador pessoal
$env:JAVA_HOME = "C:\temp\tools\Java\jdk-21"
$env:MAVEN_HOME = "C:\temp\tools\apache-maven-3.9.11"
$env:PATH = "$env:JAVA_HOME\bin;$env:MAVEN_HOME\bin;$env:PATH"