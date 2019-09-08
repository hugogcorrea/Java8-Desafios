# Gerador de frases

## Tópicos

Neste desafio você aprenderá:

- Java 8
- Testes
- SQLite
- Servlet
- JDBC

## Detalhes

A API deve responder pelas seguintes URLs:

## /v1/quote

Método: GET

Retorna uma frase aleatória de qualquer ator.


## /v1/quote/{actor}

Método: GET

Retorna uma frase aleatória do ator passado como parâmetro.

O formato esperado em ambas URLs é uma _Response JSON_:

```json
{"actor":"John Cleese","quote":"Yes, cigarettes. My hovercraft is full of eels."}
```

