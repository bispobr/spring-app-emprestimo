# API REST — Análise de Modalidades de Empréstimo

API REST desenvolvida com Java e Spring Boot para analisar as modalidades de empréstimo disponíveis para um cliente de acordo com sua idade, renda e localização.

A aplicação aplica regras de negócio para determinar quais modalidades podem ser oferecidas e retorna as respectivas taxas de juros.

## Funcionalidades

- Análise de elegibilidade para diferentes modalidades de empréstimo
- Empréstimo pessoal
- Empréstimo consignado
- Empréstimo com garantia
- Validação dos dados recebidos
- Tratamento global de exceções
- Documentação da API com Swagger/OpenAPI
- Monitoramento com Spring Boot Actuator
- Testes automatizados
- Execução em container Docker

## Regras de elegibilidade

### Empréstimo pessoal

- Renda igual ou inferior a **R$ 3.000**; ou
- Renda entre **R$ 3.000 e R$ 5.000**, desde que o cliente tenha menos de 30 anos e resida em São Paulo (SP).

**Taxa de juros:** 4%.

### Empréstimo consignado

- Renda igual ou superior a **R$ 5.000**.

**Taxa de juros:** 2%.

### Empréstimo com garantia

- Renda igual ou inferior a **R$ 3.000**; ou
- Renda entre **R$ 3.000 e R$ 5.000**, desde que o cliente tenha menos de 30 anos e resida em São Paulo (SP).

**Taxa de juros:** 3%.

## Tecnologias

- Java 21
- Spring Boot 3.4.3
- Spring Web
- Spring Validation
- Spring Boot Actuator
- Springdoc OpenAPI
- H2 Database
- Lombok
- JUnit 5
- Mockito
- Maven
- Docker

## Requisitos

- Java 21+
- Maven
- Docker (opcional)

## Executando o projeto

Clone o repositório:

```bash
git clone https://github.com/bispobr/spring-app-emprestimo.git
cd spring-app-emprestimo
```

Execute a aplicação com Maven:

```bash
mvn spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

## Swagger / OpenAPI

Com a aplicação em execução, a documentação interativa pode ser acessada em:

```text
http://localhost:8080/swagger-ui/index.html
```

## Actuator

Endpoint de saúde da aplicação:

```text
http://localhost:8080/actuator/health
```

## API Endpoint

### Analisar modalidades de empréstimo

```http
POST /customer-loans
Content-Type: application/json
```

Exemplo de requisição:

```json
{
  "age": 28,
  "income": 4000.00,
  "location": "SP",
  "name": "João da Silva",
  "cpf": "000.000.000-00"
}
```

| Campo | Tipo | Descrição |
|---|---|---|
| `age` | `Integer` | Idade do cliente. |
| `income` | `Double` | Renda mensal do cliente. |
| `location` | `String` | Localização/residência do cliente. |
| `name` | `String` | Nome do cliente. |
| `cpf` | `String` | CPF do cliente. |

Os campos estão sujeitos às regras de validação definidas pela aplicação.

## Fluxo da aplicação

```text
Cliente
   │
   ▼
POST /customer-loans
   │
   ▼
Validação dos dados
   │
   ▼
Regras de elegibilidade
   │
   ├── Empréstimo pessoal
   ├── Empréstimo consignado
   └── Empréstimo com garantia
          │
          ▼
     Resposta da API
```

## Testes

Execute os testes automatizados com:

```bash
mvn test
```

O projeto utiliza a infraestrutura de testes do Spring Boot, incluindo JUnit e Mockito.

## Docker

Gere o pacote da aplicação:

```bash
mvn clean package
```

Gere a imagem Docker:

```bash
docker build -t emprestimo .
```

Execute o container:

```bash
docker run -p 8080:8080 emprestimo
```

## Status

Projeto desenvolvido para praticar construção de APIs REST com Spring Boot, validação de dados, implementação de regras de negócio, tratamento de exceções, documentação OpenAPI, monitoramento, testes automatizados e execução em containers.
