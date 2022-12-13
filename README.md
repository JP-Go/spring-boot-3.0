# Basic CRUD com Spring Boot 3.0

Uma pequena aplicação em Spring Boot + Docker + PostgreSQL

## ⚒ Requisitos
- Docker
- Docker-compose
- Cliente PostgreSQL

## ⚡ Rodando a aplicação

1. Clone esse projeto: `git clone https://github.com/JP-Go/spring-boot-3.0.git` 
2. Entre na pasta do projeto: `cd spring-boot-3.0`
3. Crie um container docker com a configuração abaixo (ou crie um usuário com as credenciais especificadas):
```yaml
# Salvar em docker-compose.yml
version: "3"
services:
  db:
    container_name: <o nome que você quiser>
    ports:
      <uma porta de rede livre>:5432
    environment:
      POSTGRES_USER: <um nome de usuário>
      POSTGRES_PASSWORD: <uma senha segura>
```
4. Inicie o container com docker-compose `docker-compose up -d`
5. Crie a base de dados com o cliente PostgreSQL com o seguinte esquema:

```sql
CREATE TABLE customer (
                      id INT PRIMARY KEY ,
                      name VARCHAR(255),
                      email VARCHAR(255),
                      age INT);
```
6. Defina as variáveis de ambiente DB_USER e DB_PASSWORD segundo os valores
  definidos no passo 3
7. Rode a aplicação: `./gradlew bootRun`
