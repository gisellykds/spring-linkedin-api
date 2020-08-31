### Este repositório contém o código fonte de um desafio proposto pela @Zup!

#### Desafio - Imagine que você voltou no tempo e vai construir um LinkedIn, Instagram OU YouTube. Construa a API que serve uma dessas redes sociais.

#### Requisitos do Desafio: utilizar a linguagem Java e o framework Spring como tecnologias que formam a base do código. 

Linguagens, frameworks e ferramentas utilizadas:
Java 8, Spring Boot, Spring Data, JPA & Hibernate, Rest e Arquitetura MVC, Swagger, Intellij Idea, Postman e Kamban para organização.

A API escolhida para ser o MVP a ser construído foi a que servirá o LinkedIn com os seguintes endpoints.

````
VAGA 
- Cadastrar vaga por ID empresa
- Encerrar candidaturas da vaga 
- Buscar por identificador unico (ID)
- Listar todas as vagas
- Listar todas as vagas com status ABERTO
- Listar todas as vagas por empresa (ID)
- Listar todas as vagas por nivel de experiência
- Listar todas as vagas por tipo de emprego

EMPRESA
- Cadastrar empresa por ID Perfil
- Desativar empresa
- Ativar empresa
- Buscar por identificador unico (ID)
- Listar todas as empresas
- Atualizar empresa por identificador unico (ID)

CANDIDATURA 
- Candidatar-se por ID vaga e ID Perfil
- Listar candidaturas por vaga (ID)
- Listar candidaturas Usuario (ID)
- Buscar candidatura por ID vaga e ID Perfil

PERFIL
- Cadastrar perfil
- Cadastrar Experiencia Profissional por ID perfil
- Cadastrar Formacao Academica por ID perfil
- Cadastrar Licenca Certificado por ID perfil

````

PS: Temos features para implementações posteriores 😊💻

````
Experiência profissional, Formação Acadêmica e Licença Certificados

- Update
- Listagem
- Listagem por Id Perfil
- Busca por id
- Delete

````

## Vamos fazer o projeto rodar na sua máquina?

Clone o projeto que consta nesse repositório
No terminal rode o seguinte comando

``
mvn clean install
``

Na sua IDE de preferência, vá até o pacote/diretório

``
com.api.linkedin
``

Rode a classe main do projeto

``
ApiLinkedinApplication
``

Para testar os endpoints utilize a documentação como base! Abra em seu navegador o seguinte link:

``
http://localhost:8000/swagger-ui.html
``

A URL base do sistema é 

``
http://localhost:8000/
``

Para testar o banco de dados em memória - H2 database - utilize a seguinte url:

JDBCURL: jdbc:h2:mem:app

SENHA:

USERNAME: sa

``
http://localhost:8000/h2
``
