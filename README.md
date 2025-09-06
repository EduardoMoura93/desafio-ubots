# Documentação do Projeto

---

## Persistência de Dados

Para simular um cenário mais próximo de produção, este projeto utiliza **PostgreSQL** para a persistência de dados, apesar de não ser um requisito obrigatório.

### Configurações do Banco de Dados

* **Banco:** `desafio`
* **Usuário:** `desafio`
* **Senha:** `123Abc`
* **Host:** `localhost`
* **Porta:** `5432`

---

## Endpoints

A seguir estão os endpoints da API para interação com os recursos de **agentes** e **tickets**.

### Agentes

#### Criar um novo agente

* **Endpoint:** `POST /v1/agent`
* **Exemplo de body:**
    ```json
    {
    	"name": "Carlos",
    	"team": "CARTOES"
    }
    ```

#### Criar múltiplos agentes

* **Endpoint:** `POST /v1/agent/create-multiple`
* **Exemplo de body:**
    ```json
    [
      {
        "name": "Eduardo",
        "team": "CARTOES"
      },
      {
        "name": "Ana",
        "team": "CARTOES"
      },
      {
        "name": "Bruno",
        "team": "EMPRESTIMOS"
      },
      {
        "name": "Carla",
        "team": "EMPRESTIMOS"
      },
      {
        "name": "Daniel",
        "team": "OUTROS_ASSUNTOS"
      },
      {
        "name": "Fernanda",
        "team": "OUTROS_ASSUNTOS"
      }
    ]
    ```

---

### Tickets

#### Criar um novo ticket

* **Endpoint:** `POST /v1/ticket`
* **Exemplo de body:**
    ```json
    {
        "topic": "Preciso solicitar um empréstimo pessoal.",
        "team": "EMPRESTIMOS"
    }
    ```

#### Criar múltiplos tickets

* **Endpoint:** `POST /v1/ticket/create-multiple`
* **Exemplo de body:**
    ```json
    [
      {
        "topic": "Meu cartão está bloqueado.",
        "team": "CARTOES"
      },
      {
        "topic": "Preciso solicitar um empréstimo pessoal.",
        "team": "EMPRESTIMOS"
      },
      {
        "topic": "Quero atualizar meus dados cadastrais.",
        "team": "OUTROS_ASSUNTOS"
      },
      {
        "topic": "Não consigo ativar meu cartão internacional.",
        "team": "CARTOES"
      },
      {
        "topic": "Gostaria de aumentar o limite do meu empréstimo.",
        "team": "EMPRESTIMOS"
      },
      {
        "topic": "Como alterar meu endereço de cobrança?",
        "team": "OUTROS_ASSUNTOS"
      },
      {
        "topic": "Cartão com cobrança indevida.",
        "team": "CARTOES"
      },
      {
        "topic": "Solicitação de refinanciamento.",
        "team": "EMPRESTIMOS"
      },
      {
        "topic": "Pergunta sobre faturas anteriores.",
        "team": "OUTROS_ASSUNTOS"
      }
    ]
    ```

#### Finalizar um ticket

* **Endpoint:** `PUT /v1/ticket/finalize/{ticketId}`
* **Exemplo:** `PUT /v1/ticket/finalize/21`
