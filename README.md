# 🚗 Alga-Transito

O Alga-Transito é um sistema de gestão de dados relacionado a autuações de trânsito, proprietários de veículos, e os próprios veículos. Implementado em Java com Spring Boot, o projeto oferece endpoints para operações CRUD tradicionais e também inclui funcionalidades adicionais que realizam ações mais complexas.
## 🎯 Objetivo

Facilitar a administração de informações de trânsito com uma abordagem prática e escalável, integrando diversas operações de gerenciamento e automação.
## 🛠️ Funcionalidades

- Gestão de Autuações: Criar, consultar, atualizar e excluir autuações.

- Gestão de Proprietários e Veículos: Gerenciamento completo dos dados de proprietários e veículos.
- Ações Personalizadas: Endpoints para operações não-CRUD, gerenciando autuações.

## 🚀 Tecnologias e Práticas utilizadas

- Java 17
- Spring REST
- Spring Boot e Spring MVC
- Jakarta Persistence, Flyway e Lombok
- Validações com Jakarta Bean Validation
- Tratamento e modelagem de erros da API

## 📦 Instalação e execução

1. Clonar o repositório
    ```bash
    git clone https://github.com/dreackdown/algatransito.git
    cd algatransito
    ```
2. Configurar o Banco de Dados: Atualize as configurações do banco de dados no arquivo `application.properties`. 
3. Executar a aplicação:
    ```bash
    mvn spring-boot:run
    ```
   A aplicação estará acessível em <http://localhost:8080>.
## 🧪 Testando a API

Você pode testar o endpoint `/proprietarios` usando o Swagger UI, Postman, Insomnia ou cURL.

### Exemplo de chamada

```bash
{
  "nome": "José da Silva",
  "email": "jose@example.com",
  "telefone": "+111222333"
}
```

### Exemplo de resposta
```json
{
  "id": 1,
  "nome": "José da Silva",
  "email": "jose@example.com",
  "telefone": "3128762293"
}
```

## Contato

Para qualquer dúvida ou sugestão, entre em contato:

- Email: <devhugofaria@gmail.com>
- LinkedIn: [Hugo Faria Lima](https://www.linkedin.com/in/hugofarialima)