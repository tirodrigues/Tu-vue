# Auth Rest API

## Executando

Para executar a app, é preciso utilizar o Gradle 4+

$ gradle bootRun

## Autenticação

São apenas dados simulando o comportamento real de um login. Todos os dados são mockados.

### Login

URL: http://localhost:8080/api/login <br>
Método: POST <br>
Body:

```json
{
  "username": "aescobar",
  "password": "123456"
}
```

Retorno:

```json
{
  "username": "aescobar",
  "roles": [
    "ADMIN"
  ],
  "token": "87de544a-3d4f-419d-8df9-cd82321be33a",
  "expiresIn": 60
}
```

### Requisições autenticadas

Adicionar qualquer requisição o header Authorization com valor 87de544a-3d4f-419d-8df9-cd82321be33a.

## API de posts

Seguem exemplos de utilização.

### Listar

URL: http://localhost:8080/api/post <br>
Método: GET <br>
Aberta: sim

### Adicionar

URL: http://localhost:8080/api/post <br>
Método: POST <br>
Aberta: não <br>
Body:

```json
{
  "title": "This is the title",
  "description": "Lorem ipsum dolor sit amet."
}
```

Resposta:

```json
{
  "id": 1,
  "title": "This is the title",
  "description": "Lorem ipsum dolor sit amet."
}
```

### Alterar

URL: http://localhost:8080/api/post/1 <br>
Método: PUT <br>
Aberta: não <br>
Body:

```json
{
  "title": "This is the title",
  "description": "Lorem ipsum dolor sit amet."
}
```

Resposta:

```json
{
  "id": 1,
  "title": "This is the title",
  "description": "Lorem ipsum dolor sit amet."
}
```

### Remover

URL: http://localhost:8080/api/post/1
Método: DELETE <br>
Aberta: não <br>