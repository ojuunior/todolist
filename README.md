# To-Do List API

Este projeto é uma API simples para gerenciamento de tarefas (To-Do List) desenvolvida em Java utilizando Spring Boot. A aplicação permite a criação, visualização, atualização e exclusão de tarefas, com persistência dos dados em um banco de dados PostgreSQL.

## Funcionalidades

1. **Criação de Tarefas**:
   - A API permite a criação de uma nova tarefa com os seguintes campos:
     - `id`: Gerado automaticamente.
     - `título`: Obrigatório, entre 3 e 100 caracteres.
     - `descrição`: Opcional, até 500 caracteres.
     - `data de criação`: Definida automaticamente no momento da criação.
     - `data de conclusão`: Deve ser uma data futura.
     - `status`: Deve ser um dos seguintes valores: `pendente`, `em andamento`, `concluída`.

2. **Listagem de Tarefas**:
   - A API permite listar todas as tarefas cadastradas.
   - Filtro por status (`pendente`, `em andamento`, `concluída`).

3. **Atualização de Tarefas**:
   - A API permite a atualização dos dados de uma tarefa específica. Os campos que podem ser atualizados são: `título`, `descrição`, `data de conclusão`, e `status`.

4. **Exclusão de Tarefas**:
   - A API permite a exclusão de uma tarefa específica com base no seu `id`.

## Documentação da API

A API está documentada utilizando Swagger/OpenAPI. Para acessar a documentação interativa, execute a aplicação e acesse:

```
http://localhost:8080/swagger-ui.html
```

## Pré-requisitos

- **Java 17**
- **Maven 3.8+**
- **Docker**
- **PostgreSQL**

## Como Rodar a Aplicação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. **Compile e empacote a aplicação**:
   ```bash
   mvn clean package
   ```

3. **Configurando o PostgreSQL**:
   - Certifique-se de que o PostgreSQL está instalado e funcionando.
   - Crie um banco de dados chamado `todolist`.
   - Configure as credenciais de acesso ao banco de dados no arquivo `application.properties` ou como variáveis de ambiente:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
   ```

4. **Executando a aplicação com Docker**:
   - Certifique-se de que o Docker está instalado e funcionando corretamente.
   - Execute o comando:
     ```bash
     docker-compose up --build
     ```

5. **Testes**:
   - Para rodar os testes unitários, utilize o comando:
     ```bash
     mvn test
     ```

### Como Utilizar a API

Aqui estão exemplos de como interagir com a API utilizando `curl`:

#### 1. Listar todas as tarefas

```bash
curl -X GET "http://localhost:8080/todos" -H "accept: application/json"
```

#### 2. Listar tarefas por status

```bash
curl -X GET "http://localhost:8080/todos/status?status=PENDENTE" -H "accept: application/json"
```
- Substitua `PENDENTE` pelo status desejado (`PENDENTE`, `EM_ANDAMENTO`, `CONCLUIDA`).

#### 3. Obter uma tarefa por ID

```bash
curl -X GET "http://localhost:8080/todos/{id}" -H "accept: application/json"
```
- Substitua `{id}` pelo ID da tarefa que deseja obter.

#### 4. Criar uma nova tarefa

```bash
curl -X POST "http://localhost:8080/todos" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"titulo\": \"Nova Tarefa\", \"descricao\": \"Descrição da tarefa\", \"dataConclusao\": \"2024-12-31\", \"status\": \"PENDENTE\"}"
```

#### 5. Atualizar uma tarefa existente

```bash
curl -X PUT "http://localhost:8080/todos/{id}" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"titulo\": \"Tarefa Atualizada\", \"descricao\": \"Descrição atualizada\", \"dataConclusao\": \"2024-12-31\", \"status\": \"EM_ANDAMENTO\"}"
```
- Substitua `{id}` pelo ID da tarefa que deseja atualizar.

#### 6. Excluir uma tarefa

```bash
curl -X DELETE "http://localhost:8080/todos/{id}" -H "accept: application/json"
```
- Substitua `{id}` pelo ID da tarefa que deseja excluir.

## Estrutura do Projeto

- **`controller`**: Contém os controladores REST para as operações da API.
- **`service`**: Contém a lógica de negócios da aplicação.
- **`repository`**: Contém as interfaces para a comunicação com o banco de dados.
- **`model`**: Contém as classes de modelo das tarefas.
- **`exception`**: Contém as classes de tratamento de exceções.
- **`Dockerfile`**: Define como a imagem Docker da aplicação é construída.
- **`docker-compose.yml`**: Arquivo para configurar e executar os containers Docker.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Swagger/OpenAPI**
- **JUnit**
- **Mockito**
- **Docker**

---
