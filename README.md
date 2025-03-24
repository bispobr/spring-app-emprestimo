# spring-app-emprestimo

Este repositório contém um projeto simples desenvolvido com Java Spring, com o objetivo de praticar e aplicar conceitos dessa tecnologia. A aplicação determina as modalidades de empréstimo disponíveis para um cliente, retornando seu nome e uma lista de empréstimos acessíveis, incluindo os tipos e as taxas de juros correspondentes. Seguindo os detalhes abaixo

## Requisitos

As modalidades de empréstimo que serão analisadas são:

- **Empréstimo pessoal**: Taxa de juros de 4%.
- **Empréstimo consignado**: Taxa de juros de 2%.
- **Empréstimo com garantia**: Taxa de juros de 3%.

As modalidades de empréstimo disponíveis para uma pessoa são baseadas em algumas variáveis específicas, são elas:

- **Idade**
- **Salário**
- **Localização**

Os emprestimos Possuem as seguintes condições:

- Conceder o empréstimo pessoal se o salário do cliente for igual ou inferior a R$ 3000.
- Conceder o empréstimo pessoal se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30
  anos e residir em São Paulo (SP).
- Conceder o empréstimo consignado se o salário do cliente for igual ou superior a R$ 5000.
- Conceder o empréstimo com garantia se o salário do cliente for igual ou inferior a R$ 3000.
- Conceder o empréstimo com garantia se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver
  menos de 30 anos e residir em São Paulo (SP).

## Instalação

1. Clone o repositório:

```bash
git https://github.com/bispobr/spring-app-emprestimo.git
```

2. Instale as dependências com Maven

## Como usar

1. Inicie a aplicação
2. A API está acessivel atraves do endereço http://localhost:8080

## API Endpoints

A API contem o seguinte endpoint :

```http request
POST /customer-loans - Registra um novo cliente.
Content-Type: application/json

{
  "age": 00,
  "income": 0000.00,
  "localation": "xx",
  "name": "xxxxxx",
  "cpf": "000.000.000-00"
}
```