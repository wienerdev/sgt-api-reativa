<br>
<h1 align="center">
API Reativa para Gerenciamento de Tarefas 📑
</h1>
<br>

## 💬 Sobre o repositório

API reativa desenvolvida para um sistema de gerenciamento de tarefas, utilizando Java 11, Spring Boot, Webflux, MongoDB e Maven.

## ⚠ Pré-requisitos para execução do projeto

* Java 11 ou versões superiores
* Maven 3.8.5 ou versões superiores
* Docker para o banco de dados

## 🛠 Tecnologias utilizadas

Esse projeto foi desenvolvido com as seguintes tecnologias:

* [Docker](https://www.docker.com/)
* [Java](https://www.oracle.com/br/java/)
* [Maven](https://maven.apache.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Webflux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)
* [MongoDB](https://www.mongodb.com/pt-br)

## 📌 Como utilizar?

Para rodar o banco de dados em uma imagem docker, digite o seguinte comando na raiz principal do projeto:

```shell script
docker-compose up
```

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta mandar uma requisição JSON para os um dos links da lista de funcionalidades e seus endpoints:

```
Buscar todas as tarefas (GET): http://localhost:8080/tarefas
Buscar uma tarefa por ID (GET): http://localhost:8080/tarefas/<id>
Deletar uma tarefa por ID (DELETE): http://localhost:8080/deleteTarefa/<id>
Atualizar uma tarefa por ID (PUT): http://localhost:8080/updateTarefa/<id>
Criar ou salvar uma tarefa (POST): http://localhost:8080/saveTarefa
```

Para conferir se as operações de gerenciamento de usuários estão funcionando, utilize o Postman, [clique aqui para ver!](https://ibb.co/0QMytWZ)

## 🧠 Links importantes

* [Documentação oficial do Lombok](https://projectlombok.org/)
* [Documentação oficial do Webflux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)
* [Documentação oficial do Map Struct](https://mapstruct.org/)
* [Referência para o padrão arquitetural REST](https://restfulapi.net/)
* [Palheta de atalhos de comandos do IntelliJ](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial do Spring Initialzr para setup do projeto](https://start.spring.io/)
* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)

---
