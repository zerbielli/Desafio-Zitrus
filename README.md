# Desafio Zitrus

Você é o desenvolvedor responsável por um sistema de controle de autorizações de procedimentos médicos para um plano de
saúde. Os critérios para permitir a execução de um procedimento são idade e sexo, de acordo com a tabela a seguir:

| PROCEDIMENTO  | IDADE | SEXO | PERMITIDO | 
| :------------ |:-----:|-----:|-----------|
| 1234|  10   |    M | NÃO       |
| 4567|  20   |    M | SIM       |
| 6789|  10   |    F | NÃO       |
| 6789|  10   |    M | SIM       |
| 1234|  20   |    M | SIM       |
| 4567|  30   |    F | SIM       |

Procedimentos não listados na tabela devem ser negados no cadastro, com mensagens de
retorno da requisição, justificados.

## Tecnologias
As seguintes ferramentas foram usadas na construção do projeto:

- ``Spring Boot v2.6.5``
- ``Maven v3.8.4``
- ``Java 11``
- ``Banco H2``
- ``Liquibase``
- ``InteliJ IDEA``

## Estrutura de banco
- `PROCEDIMENTOS`: Tabela  que contém os procedimentos
- `PROCEDIMENTOS_REGRAS`: Tabela que contém os procedimentos e as regras para autorização (sexo e idade);
- `AUTORIZACOES`: Tabela para manter os cadastros autorizações (Autorizadas, Não Autorizadas e Canceladas);

![Alt text](src/main/resources/static/ER_Diagrama.png?raw=true "ER Diagrama")

## Funcionalidades do projeto

- `Autorizar`: Tela para cadastro de Autorizações seguido de listagem dos regstros criados.
- `Autorizações` : Listagem de autorizações.

## Lógica de autorização

As autorizações são aplicadas da seguinte forma:<p>
A tabela de `PROCEDIMENTOS` contém a lista de procedimentos não repetidos que serve para popular o dropDown de escolha do procedimento a ser autorizado.
<br/>Após a escolha do procedimento o usuário irá informar a idade e sexo e então clicar no botão Autorizar. Ao clicar em Autorizar a aplicação fará uma busca
na tabela `PROCEDIMENTOS_REGRAS` onde existem as combinações possíveis para AUTORIZAR o procedimento conforme sexo e idade informados.
<br/>Os registros Não Autorizados são aqueles que não são encontrados nas combinações da tabela `PROCEDIMENTOS_REGRAS`.
<p>

## Executar aplicação
Pode ser utilizado uma das seguintes formas

### Spring run
```
$ ./mvnw spring-boot:run
```
Caso ocorra algum erro relacionado a _maven-wrapper_ executar o comando
```
$ mvn wrapper:wrapper

$ ./mvnw spring-boot:run
```
### Java
```
$ mvn package

$ java -jar target/DesafioZitrus-0.0.1-SNAPSHOT.jar
```
#### Acessar sistema em http://localhost:8080/
#### Acessar banco H2 em http://localhost:8080/h2
- ``JDBC URL: jdbc:h2:mem:desafio``
- ``User Name: sa``