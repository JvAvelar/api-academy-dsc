 <div align="center">
  
<h1>  API de Gerenciamento de Academia</h1> 

<h3> Este projeto é uma API RESTful para gerenciamento de uma academia, desenvolvida com Java e Spring Boot. O foco principal é a implementação de um sistema de segurança robusto para proteger os endpoints, utilizando autenticação via JSON Web Tokens (JWT). </h3>

</div>

# 

### 🚀  Tecnologias Utilizadas
* Java 21

* Spring Boot 3

* Spring Security 6: Para autenticação e autorização.

* JSON Web Tokens (JWT): Para autenticação stateless.

* Spring Data JPA (Hibernate): Para persistência de dados.

* PostgreSQL: Banco de dados relacional.

#

### ⚙️ Funcionalidades
* CRUD completo para Usuários, Equipamentos e Academias.

* Sistema de autenticação e autorização seguro.

* Tratamento de exceções centralizado.

* Validação de dados de entrada.

#

### 🛡️ Sistema de Segurança e Autenticação
A segurança da API é implementada utilizando Spring Security com autenticação baseada em JSON Web Tokens (JWT), garantindo que a comunicação seja stateless (sem estado).

O fluxo de autenticação funciona da seguinte maneira:

  #### **Registro de Usuário**

  Endpoint: POST /api/auth/register
  
  Descrição: Um endpoint público que permite a criação de novos usuários. O sistema valida se o username já existe no banco de dados para evitar duplicidade. A senha do usuário é criptografada com BCryptPasswordEncoder antes de ser salva.
  
  #### **Login e Obtenção do Token**
  
  Endpoint: POST /api/auth/login
  
  Descrição: Um endpoint público que recebe username e password. As credenciais são validadas pelo AuthenticationManager do Spring Security.
  
  Resposta: Em caso de sucesso, a API retorna um token JWT válido, que contém as permissões (roles) do usuário e um tempo de expiração.
  
  #### Acesso a Rotas Protegidas
  
  Descrição: Todos os outros endpoints da API (ex: GET /academy/user) são protegidos. Para acessá-los, o cliente deve incluir o token JWT no cabeçalho Authorization de cada requisição.
  
  Formato do Cabeçalho: Authorization: Bearer <seu_token_jwt>
  
  #### Validação do Token
  
  Descrição: Um filtro customizado (JwtAuthenticationFilter) intercepta todas as requisições. Ele verifica a validade do token (assinatura e tempo de expiração), extrai as informações do usuário e o carrega no contexto de segurança do Spring, permitindo que a requisição prossiga para o controller.

#

### 🛠️ Configuração e Execução
#### Pré-requisitos:
* Java 21 ou superior

* Maven 3.8+

* PostgreSQL rodando (localmente ou online)

#### Banco de Dados
O projeto está configurado para se conectar a um banco de dados PostgreSQL. As credenciais de conexão (URL, username, password) devem ser ajustadas no arquivo **src/main/resources/application.yml**.

A propriedade **spring.jpa.hibernate.ddl-auto=update** fará com que o Hibernate crie ou atualize as tabelas automaticamente na primeira inicialização.

#

### Executando a Aplicação
Clone o repositório.

Configure as variáveis do banco de dados no arquivo de propriedades.

Execute a classe principal AcademyApplication.java.

A API estará disponível em http://localhost:8080.

**Swagger**: http://localhost:8080/swagger-ui/index.html#/
