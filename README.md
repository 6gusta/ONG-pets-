
---

 **ONG-pets- (Backend Spring Boot)**

```markdown
# Sistema de Adoção de Pets - Backend Spring Boot

## Visão Geral

Este projeto consiste na API RESTful para o sistema de adoção de pets, construída com Java e Spring Boot. Ele é responsável por gerenciar toda a lógica de negócio, autenticação, autorização, persistência de dados e regras da aplicação, permitindo a integração com frontends e outros serviços.

---

## Motivação

Criar uma API robusta, segura e escalável para apoiar o frontend do sistema de adoção, garantindo que as operações relacionadas a usuários, pets e autenticação sejam feitas de forma eficiente e confiável.

---

## Funcionalidades Principais

- Autenticação e autorização com Spring Security e JWT.
- CRUD completo para cadastro, atualização, exclusão e listagem de pets.
- Gestão de usuários com roles (perfis) para controle de acesso.
- Integração com banco de dados relacional MySQL via Spring Data JPA.
- Estrutura em camadas com controllers, serviços e repositórios.
- Suporte a logs e tratamento centralizado de exceções.
- Dockerização para facilitar deploy e ambiente de desenvolvimento.

---

## Arquitetura do Projeto

- **Controller**: Endpoints REST para manipulação das requisições.
- **Service**: Regras de negócio e validações.
- **Repository**: Interface de acesso a dados.
- **Model/Entity**: Representação das tabelas do banco.
- **Security**: Configuração de segurança, filtros JWT e handlers.
- **DTOs**: Objetos de transferência de dados para desacoplamento.

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot 3+
- Spring Security (JWT)
- Spring Data JPA
- MySQL
- Maven
- Docker

---

## Como Rodar o Projeto

### Pré-requisitos

- Java JDK 17+
- Maven
- Banco de dados MySQL configurado (local ou container)

### Passos para execução

```bash
git clone https://github.com/6gusta/ONG-pets-.git
cd ONG-pets-
# Ajustar application.properties para conexão com banco
mvn spring-boot:run
