````
# 💸 Banco - Sistema de Transferências Bancárias

Este projeto é uma API REST desenvolvida com Spring Boot que simula operações bancárias simples, como transferências entre contas, registro de saldo e filtros por intervalo de valores.

## 🚀 Funcionalidades

- 💳 Transferência entre contas
- 📊 Listagem de contas com contagem de ocorrências
- 🔍 Filtro de contas por saldo final
- 🧾 Registro automático de data e hora da transação
- ✅ Validações com Jakarta Validation
- 🔄 DTOs com Java Records
- 🗃️ JPA com Spring Data

## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Jakarta Validation
- MySQL (ou H2 para testes)
- Maven

## 📂 Estrutura do projeto

- `model`: Entidade JPA `Conta`
- `dto`: Representações `ContaDTO`
- `repository`: Interface de persistência com filtros personalizados
- `service`: Regras de negócio (transferência, listagem, filtro)
- `controller`: Endpoints REST

## 📦 Requisitos para rodar

- Java 17+
- Maven
- MySQL (ou H2 para testes locais)

## ▶️ Como rodar

```bash
git clone https://github.com/MSouza27/banco.git
cd banco
./mvnw spring-boot:run
````

## 📮 Endpoints principais

* `POST /conta` → Realiza transferência entre contas
* `GET /conta/listar` → Lista contas com contagem
* `GET /conta/filtrar?saldoMinimo=100&saldoMaximo=1000` → Filtra contas por saldo final

## 📨 Exemplo de requisição (POST /conta)

```json
{
  "numeroConta": 123456,
  "saldoDaConta": 1000.00,
  "saldoTransferido": 200.00,
  "numeroContaCredito": 654321,
  "saldoContaCredito": 500.00,
  "saldoRecebido": 200.00,


}
```

**Observação:** Os campos `saldoFinal`, `saldoFinalCredito` e `dataHora` são calculados automaticamente.

## 🧑‍💻 Autor

Projeto desenvolvido por [MSouza27](https://github.com/MSouza27) para fins de aprendizado e demonstração de domínio com Spring Boot.

```
