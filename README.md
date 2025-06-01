# API REST - Análise de Modalidades de Empréstimo

## Descrição

Esta API REST tem como objetivo determinar as modalidades de empréstimo disponíveis para um cliente com base em critérios pré-definidos. A resposta da API inclui o nome do cliente e uma lista de empréstimos acessíveis, contendo os respectivos tipos e taxas de juros.


## Funcionalidades

- Avaliação de elegibilidade para três tipos de empréstimo:
  - **Empréstimo Pessoal**: 4% de juros
  - **Empréstimo Consignado**: 2% de juros
  - **Empréstimo com Garantia**: 3% de juros
- A lógica de concessão considera as seguintes variáveis:
  - Idade
  - Localização
  - Salário

### Regras de elegibilidade

- **Empréstimo Pessoal**
  - Disponível se o salário for **≤ R$ 3.000**
  - Disponível se o salário estiver entre **R$ 3.000 e R$ 5.000**, **o cliente tiver menos de 30 anos** e **residir em São Paulo (SP)**

- **Empréstimo Consignado**
  - Disponível se o salário for **≥ R$ 5.000**

- **Empréstimo com Garantia**
  - Disponível se o salário for **≤ R$ 3.000**
  - Disponível se o salário estiver entre **R$ 3.000 e R$ 5.000**, **o cliente tiver menos de 30 anos** e **residir em São Paulo (SP)**

## Tecnologias Utilizadas

- **Java + Spring Boot**: Framework principal da aplicação
- **Lombok (@Slf4j)**: Geração de logs com facilidade e redução de boilerplate
- **Swagger**: Geração de documentação interativa da API
- **Spring Boot Actuator**: Aplicação de observabilidade e monitoramento, incluindo endpoints de health check
- **Integração Swagger + Actuator**: Permite visibilidade operacional integrada com a documentação da API

## Requisitos

- Java 21+
- Maven

## Executando o Projeto

1. Clone o repositório:

```bash
git https://github.com/bispobr/spring-app-emprestimo.git
```

## Como usar

1. Inicie a aplicação
2. A API está acessivel atraves do endereço http://localhost:8080
3. A documentação da API está acessível através do Link http://localhost:8080/swagger-ui/index.html#/
4. O endpoint de saúde e métricas do Actuator está acessível através do Link http://localhost:8080/actuator/health
## API Endpoints

A API contem o seguinte endpoint :

```http request
POST /customer-loans - Registra um novo cliente.
Content-Type: application/json

{
  "age": 00,
  "income": 0000.00,
  "location": "xx",
  "name": "xxxxxx",
  "cpf": "000.000.000-00"
}
```
| Parâmetro | Tipo      | Descrição                           |
|:----------|:----------| :---------------------------------- |
| `age`     | `Integer` | **Obrigatório**.  A idade do usuário 
| `income`   | `Double`  | **Obrigatório**. O salario do usuário 
| `location`    | `String`  | **Obrigatório**. A residência do usuário 
| `name`   | `String`  | **Obrigatório**. O nome do usuário 
| `cpf`    | `String`  | **Obrigatório**. O crf do usuário 
