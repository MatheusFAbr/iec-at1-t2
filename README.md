# API de Pokémons

API REST para gerenciamento de Pokémons desenvolvida com Spring Boot.

## Rotas Disponíveis

Todas as rotas estão disponíveis no endpoint base: `/atv/pokemons`

### 1. Listar todas as Pokémons

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

### Opção 1: Executar localmente com Maven

1. Certifique-se de ter Java 21 e Maven instalados
2. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
3. A API estará disponível em `http://localhost:8080`

### Opção 2: Executar com Docker

1. **Build da imagem Docker:**
   ```bash
   docker build -t at1-t1-matheus-ferrari .
   ```

2. **Executar o contêiner:**
   ```bash
   docker run -p 8080:8080 at1-t1-matheus-ferrari
   ```

3. A API estará disponível em `http://localhost:8080`

### Opção 3: Usar imagem do Docker Hub

Se a imagem estiver disponível no Docker Hub:
```bash
docker run -p 8080:8080 <seu-usuario>/at1-t1-matheus-ferrari:latest
```

## Docker

### Build da Imagem

O projeto inclui um `Dockerfile` multi-stage que:
- Compila a aplicação usando Maven
- Cria uma imagem final otimizada com apenas o JAR
- Usa Java 21 JRE para reduzir o tamanho da imagem

### Workflow Docker CD

O projeto possui um workflow GitHub Actions (`.github/workflows/docker-cd.yml`) que:
- Executa automaticamente na branch `main`
- Constrói a imagem Docker usando contêineres
- Faz push da imagem para o Docker Hub

#### Configuração dos Secrets no GitHub

Para o workflow funcionar, configure os seguintes secrets no repositório:

1. Vá em **Settings** → **Secrets and variables** → **Actions**
2. Adicione os seguintes secrets:
   - `DOCKER_USERNAME`: Seu usuário do Docker Hub
   - `DOCKER_PASSWORD`: Seu token de acesso do Docker Hub (ou senha)

**Como obter o token do Docker Hub:**
1. Acesse https://hub.docker.com/settings/security
2. Clique em "New Access Token"
3. Dê um nome e copie o token gerado

## Documentação da API

Após iniciar a aplicação, a documentação Swagger estará disponível em:
- `http://localhost:8080/swagger-ui.html`

