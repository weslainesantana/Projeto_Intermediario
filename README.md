# Documentação para rodar API Marketplace

---

## Documentação Docker

### Executando o `docker-compose.yml`

```bash
docker compose up -d
```
### Criando e rodando um container a partir de um Dockerfile

```bash
docker build -t api .
```

### Rode o container com o seguinte comando:

```bash
docker run -dti -p 8080:8080 api
```

---

## Documentação CRUD da API

### Produtos

#### POST `/products`

- Cria um novo produto.

**Exemplo de corpo da requisição (JSON):**

```json
{
    "name": "Notebook",
    "description": "Acer Aspire 3",
    "price": 4000.00
}
```

**Resposta de Sucesso (201 Created):**

```json
{
    "id": 1,
    "name": "Notebook",
    "description": "Acer Aspire 3",
    "price": 4000.00
}
```

---

#### GET `/products`

- Retorna todos os produtos cadastrados.

**Exemplo de Resposta (200 OK):**

```json
[
    {
        "id": 1,
        "name": "Notebook",
        "description": "Acer Aspire 3",
        "price": 4000.00
    },
    {
        "id": 2,
        "name": "Pc gamer",
        "description": "Pc gamer rgb",
        "price": 4000.00
    }
]
```

---

#### GET `/products/{id}`

- Retorna um produto específico pelo seu ID.

**Exemplo de Resposta (200 OK):**

```json
{
    "id": 1,
    "name": "Notebook",
    "description": "Acer Aspire 3",
    "price": 4000.00
}
```

---

#### PUT `/products/{id}`

- Atualiza um produto específico pelo seu ID.

**Exemplo de corpo da requisição (JSON):**

```json
{
    "name": "Pc gamer", 
    "description": "Pc gamer rgb", 
    "price": 4000.00
}
```

**Resposta de Sucesso (200 OK):**

```json
{
    "id": 1,
    "name": "Pc gamer", 
    "description": "Pc gamer rgb", 
    "price": 4000.00
}
```

---

#### DELETE `/products/{id}`

- Remove um produto específico pelo seu ID.

**Resposta de Sucesso (200 OK):**

```json
{
    "id": 1,
    "name": "Pc gamer", 
    "description": "Pc gamer rgb", 
    "price": 4000.00
}
```

---

### Clientes

#### POST `/client`

- Cria um novo cliente.

**Exemplo de corpo da requisição (JSON):**

```json
{
    "name": "weslaine",
    "cep": "01001000",
    "email": "teste@teste.com"
}
```

**Resposta de Sucesso (201 Created):**

```json
{
    "id": 2,
    "name": "weslaine",
    "cep": "01001000",
    "email": "teste@teste.com"
}
```

---

#### GET `/client/{id}`

- Retorna os dados de um cliente específico pelo seu ID, incluindo informações adicionais com base no CEP.

**Exemplo de Resposta (200 OK):**

```json
{
    "id": 2,
    "name": "weslaine",
    "cep": "01001000",
    "email": "teste@teste.com",
    "logradouro": "Praça da Sé",
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "localidade": "São Paulo",
    "uf": "SP",
    "ibge": "3550308",
    "gia": "1004",
    "ddd": "11",
    "siafi": "7107"
}
```

---
