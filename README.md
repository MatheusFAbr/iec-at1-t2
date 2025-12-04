# API de pokemons

API REST para gerenciamento de Pokémons desenvolvida com Spring Boot.

## Rotas Disponíveis

Todas as rotas estão disponíveis no endpoint base: `/atv/pokemons`

### 1. Listar todas as pokemons

**GET** `/atv/pokemons`

Retorna uma lista com todos os Pokémons cadastrados.

**Exemplo de requisição:**
```bash
curl http://localhost:8080/atv/pokemons
```

**Exemplo de resposta:**
```json
[
  {
    "id": "1",
    "nome": "Pikachu",
    "tipo": "Elétrico",
    "geracao": "1"
  },
  {
    "id": "2",
    "nome": "Charmander",
    "tipo": "Fogo",
    "geracao": "1"
  },
  {
    "id": "3",
    "nome": "Bulbasaur",
    "tipo": "Planta/Veneno",
    "geracao": "1"
  }
]
```

### 2. Buscar pokemon por ID

**GET** `/atv/pokemons/{id}`

Retorna os dados de um Pokémon específico pelo seu ID.

**Exemplo de requisição:**
```bash
curl http://localhost:8080/atv/pokemons/1
```

**Exemplo de resposta:**
```json
{
  "id": "1",
  "nome": "Pikachu",
  "tipo": "Elétrico",
  "geracao": "1"
}
```

### 3. Criar novo pokemon

**POST** `/atv/pokemons`

Cria um novo Pokémon no sistema.

**Exemplo de requisição:**
```bash
curl -X POST http://localhost:8080/atv/pokemons \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Led Zeppelin",
    "genero": "Rock",
    "anoFormacao": "1968"
  }'
```

**Exemplo de resposta:**
```json
{
  "id": "4",
  "nome": "Squirtle",
  "tipo": "Água",
  "geracao": "1"
}
```

### 4. Atualizar pokemon

**PUT** `/atv/pokemons/{id}`

Atualiza todos os dados de um Pokémon existente.

**Exemplo de requisição:**
```bash
curl -X PUT http://localhost:8080/atv/pokemons/1 \
  -H "Content-Type: application/json" \
  -d '{
    "id": "1",
    "nome": "Pikachu",
    "tipo": "Elétrico",
    "geracao": "1"
  }'
```

**Exemplo de resposta:**
```json
{
  "id": "1",
  "nome": "Pikachu",
  "tipo": "Elétrico",
  "geracao": "1"
}
```

### 5. Deletar pokemon

**DELETE** `/atv/pokemons/{id}`

Remove um Pokémon do sistema.

**Exemplo de requisição:**
```bash
curl -X DELETE http://localhost:8080/atv/pokemons/1
```

**Exemplo de resposta:**
```
Pokémon 1 removido
```

## Estrutura de Dados

Cada Pokémon possui os seguintes campos:

- `id`: Identificador único (gerado automaticamente)
- `nome`: Nome do Pokémon
- `tipo`: Tipo do Pokémon (ex.: Água, Fogo, Elétrico, Planta/Veneno)
- `geracao`: Geração do Pokémon

## Dados Iniciais

A API já vem com 3 Pokémons pré-cadastrados:

1. **Pikachu** - Elétrico (Geração 1)
2. **Charmander** - Fogo (Geração 1)
3. **Bulbasaur** - Planta/Veneno (Geração 1)

## Como Executar

1. Certifique-se de ter Java 21 e Maven instalados
2. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
3. A API estará disponível em `http://localhost:8080`

## Documentação da API

Após iniciar a aplicação, a documentação Swagger estará disponível em:
- `http://localhost:8080/swagger-ui.html`

