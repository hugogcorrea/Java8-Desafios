# Gerenciar times de futebol

Os dados devem ficar armazenados na memória.

## Requisitos de Sistema

- Parâmetros com `*` são obrigatórios.
- Os parâmetros, com exceção de identificadores, são sempre íntegros e farão sentido.

### @Desafio("incluirTime)"

Realiza a inclusão de um novo time.

**Exceções:**

Caso o `identificador` já exista, retornar exceção

### @Desafio("incluirJogador)"

Realiza a inclusão de um novo jogador.

**Exceções:**

Caso o `identificador` já exista, retornar exceção
Caso o time informado não exista, retornar exceção

### @Desafio("definirCapitao")

Define um jogador como capitão do seu time. Um time deve ter apenas um capitão, por tanto o capitão anterior voltará a ser apenas jogador.

**Exceções:**

Caso o jogador informado não exista, retornar exceção

### @Desafio("buscarCapitaoDoTime")

Mostra o `identificador` do capitão do time.

Long `idTime`* Identificador do Time

**Exceções:**

Caso o time informado não exista, retornar exceção

Caso o time informado não tenha um capitão, retornar exceção

### @Desafio("buscarNomeJogador")

Retorna o `nome` do jogador.

Long `idJogador`* Identificador do jogador

**Exceções**

Caso o jogador informado não exista, retornar exceção

### @Desafio("buscarNomeTime")

Retorna o `nome` do time.

Long `idTime`* Identificador do Time

**Exceções**

Caso o time informado não exista, retornar exceção

### @Desafio("buscarJogadoresDoTime")

Retorna a lista com o `identificador` de todos os jogadores do time, ordenada pelo `id`.

Long `idTime`* Identificador do Time

**Exceções**

Caso o time informado não exista, retornar exceção

### @Desafio("buscarMelhorJogadorDoTime")

Retorna o `identificador` do melhor jogador do time.

Long `idTime`* Identificador do time.

**Exceções**:

Caso o time informado não exista, retornar exceção

### @Desafio("buscarJogadorMaisVelho")

Retorna o `identificador` do jogador mais velho do time. Usar o menor `identificador` como critério de desempate.

Long idTime* Identificador do time

Caso o time informado não exista, retornar exceção

### @Desafio("buscarTimes")

Retorna uma lista com o `identificador` de todos os times cadastrado, ordenada pelo `identificador`.
Retornar uma lista vazia caso não encontre times cadastrados.

### @Desafio("buscarJogadorMaiorSalario")

Retorna o `identificador` do jogador com maior salário do time. Usar o menor `identificador` como critério de desempate.

Long `idTime`* Identificador do time.

**Exceções**:

Caso o time informado não exista, retornar exceção

### @Desafio("buscarSalarioDoJogador")

Retorna o `salário` do jogador.

Long `idJogador`* Identificador do jogador

**Exceções**:

Caso o jogador informado não exista, retornar exceção

### @Desafio("buscarTopJogadores")

Retorna uma lista com o `identificador` dos `top` melhores jogadores, utilizar o menor `identificador` como critério de desempate.

Integer `top`* Quantidade de jogares na lista

**Exceções**:

Caso não exista nenhum jogador cadastrado, retornar uma lista vazia.

### @Desafio("buscarCorCamisaTimeDeFora")

Retorna a `cor da camisa` do time adversário. 
Caso a `cor principal` do time da casa seja **igual** a `cor principal` do time de fora, retornar `cor secundária` do time de fora.
Caso a `cor principal` do time da casa seja **diferente** da `cor principal` do time de fora, retornar `cor principal` do time de fora.

Long `idTimeDaCasa`* Identificador do time da casa
Long `idTimeDeFora`* Identificador do time de fora


