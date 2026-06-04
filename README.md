# Senha Segura

Implementação do desafio [Senha Segura](https://github.com/backend-br/desafios/blob/master/secure-password/PROBLEM.md) proposto pela comunidade [backend-br](https://github.com/backend-br/desafios).

API REST feita em Spring Boot que valida se uma senha atende aos critérios mínimos de segurança.

## Endpoints

### `POST /password/verification`

Valida uma senha com base nos critérios definidos.

**Request body:**
```json
{
  "password": "SuaSenha@123"
}
```

**Senha válida — 204 No Content**

Nenhum corpo na resposta.

**Senha inválida — 400 Bad Request**
```json
[
  "Password must be at least 8 characters long",
  "Password must contain at least one uppercase letter"
]
```

## Critérios de validação

- Mínimo de 8 caracteres
- Pelo menos uma letra maiúscula
- Pelo menos uma letra minúscula
- Pelo menos um dígito numérico
- Pelo menos um caractere especial (ex: `!@#$%`)

## Como rodar

**Pré-requisitos:** Java 17+ e Maven

```bash
git clone https://github.com/seu-usuario/senha-segura.git
cd senha-segura
mvn spring-boot:run
```

A aplicação sobe na porta `8080` por padrão.

## Testando

```bash
# senha válida
curl -X POST http://localhost:8080/password/verification \
  -H "Content-Type: application/json" \
  -d '{"password": "vYQIYxO&p$yfI^r"}'

# senha inválida
curl -X POST http://localhost:8080/password/verification \
  -H "Content-Type: application/json" \
  -d '{"password": "fraca"}'
```
