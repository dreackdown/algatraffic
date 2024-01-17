# Algatraffic Administração de Trânsito
## Projeto Backend AlgaWorks

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySql](https://img.shields.io/badge/MySQL-4479A1.svg?style=for-the-badge&logo=MySQL&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

Este projeto é uma API construída com **Java, Java Spring and MySql.**

## Índice

- [Uso](#uso)
- [Endpoints da API](#api-endpoints)

## Usage

1. Inicie a aplicação com o Maven
2. A API estará acessível em http://localhost:8080

## API Endpoints
A API fornece os seguintes endpoints:

**API PROPRIETARIO**
```markdown
POST /proprietarios - Cria um novo proprietário
GET /proprietarios - Recupera todos os proprietários
GET /proprietarios/{id} - Recupera um proprietário
PUT /proprietarios/{id} - Atualiza um proprietário
DELETE /proprietarios/{id} - Apaga um proprietário
```

**CORPO**
```json
{
  "nome": "arya",
  "email": "arya@example.com",
  "telefone": "+111222333"
}
```

**API VEÍCULO**
```markdown
POST /veiculos - Cria um novo veículo
GET /veiculos - Recupera todos os veículos
GET /veiculos/{id} - Recupera um veículo
PUT /veiculos/{id} - Atualiza um veículo
DELETE /veiculos/{id} - Apaga um veículo
```

**BODY**
```json
{
  "proprietario": {
        "id": 1
    },
  "marca": "Honda",
  "modelo": "Civic",
  "placa": "QBN7F89"
}
```
