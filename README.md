# Cadastro Ninja - Projeto Java Spring (2º Bimestre)

Este projeto foi desenvolvido como parte da disciplina de **Programação Avançada**. O objetivo é criar uma **API REST** para cadastro de **ninjas**, **vilas** e **jutsus**, utilizando **Java**, **Spring Boot** e banco de dados **MySQL com Docker**.

---

## 📋 Descrição do Projeto

A aplicação tem como base o projeto `exemplo_spring` fornecido em aula e foi expandida com as seguintes funcionalidades:

### 🏘️ 1. Entidade Vila

**Atributos:**
- `nome`: Nome da vila.
- `numeroHabitantes`: Quantidade de habitantes da vila.

**Relacionamento:**  
1:N com **Ninja** (uma vila pode ter vários ninjas).

### 🌀 2. Entidade Jutsu

**Atributos:**
- `nome`: Nome do jutsu.
- `descricao`: Descrição detalhada do jutsu.
- `dificuldade`: Nível de dificuldade.

**Relacionamento:**  
N:N com **Ninja** (um ninja pode saber vários jutsus, e um jutsu pode ser usado por vários ninjas).

### 🧩 3. Componentes Criados

Para as entidades **Vila** e **Jutsu**, foram implementados:
- `Models`
- `Repositories`
- `Services`
- `DTOs`
- `Controllers`

---

## 🛠️ Tecnologias Utilizadas

- Java 21  
- Spring Boot 3.4.5  
- Maven  
- MySQL 8 (via Docker)  
- Spring Data JPA  
- Lombok  
- Swagger UI  

---

## ▶️ Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/agace/teste_spring.git
cd teste_spring

Execute para subir o banco:

### Execute para subir o banco:

docker-compose up -d

Este comando inicia um container MySQL com o banco teste_spring e importa o backup automaticamente.

### Restaure o banco com backup.sql (opcional)

Caso deseje importar dados de exemplo:

docker exec -i <nome-do-container> mysql -u root -p teste_spring < backup.sql
Substitua <nome-do-container> pelo nome ou ID do container MySQL.
A senha estará no compose.yaml.

### Após a aplicação estar em execução, acesse:

http://localhost:8080/swagger-ui.html

Nessa interface, é possível testar todos os endpoints disponíveis da API.


