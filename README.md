<div align="center">
  <h1 align="center">
API REST - Fórum de Discussões
    <br />
    <br />
    <a href="Cadeado">
      <img src="src/main/java/br/com/alura/Livros/Assets/ImagemSistema.png" alt="Imagem Ilustrando o Back-Endo do Sistema"  width="300" height="200">
     </a>
  </h1>
</div>
<h1 align="center"> Introdução </h1>

- * Sistema de uma API completa para gerenciamento de tópicos e respostas.

Este projeto FórumHub  foi desenvolvido como parte do **Challenge Back End**,uma iniciativa da [**Alura**](https://www.alura.com.br/) em parceria com o programa [**Oracle Next Education**](https://www.oracle.com/br/education/oracle-next-education/). O sistema foi projetado para Facilitar o gerenciamento de discussões e soluções. povoando o banco de dados   com conteúdo relevante. 
O desafio proposto pelo curso de desenvolvimento de sistemas visou não apenas o domínio técnico, mas também a compreensão de conceitos fundamentais . Este projeto reflete o comprometimento com a inovação e a excelência técnica, aplicando conhecimentos adquiridos ao longo do curso . 

<h1 align="center"> Funcionalidades </h1><br>

- *Descrição* <br>
A FórumHub API é uma API RESTful desenvolvida com Spring Boot e JPA, projetada para facilitar a interação em fóruns de discussão. Ela permite o gerenciamento de tópicos de dúvidas e respostas, com recursos robustos de autenticação e segurança, incluindo a geração e validação de tokens JWT.
Com endpoints organizados e funcionalidades práticas, o FórumHub é ideal para plataformas de compartilhamento de conhecimento. <br>

- *A API disponibiliza os seguintes recursos:*<br>

  - *Autenticação*
   Post / Usuarios<br>
    Cria um novo usúario<br>

  -*POST /login* <br>
    Realiza a autenticação do usuário e retorna um token JWT para acesso aos recursos protegidos.<br>

  -*Tópicos*
  POST /topicos
    Cria um novo tópico de discussão.

  GET /topicos<br>
    Lista todos os tópicos disponíveis.<br>
    Obs (neste topico, use este formato no corpo da requisição<br>
           {<br>
            "status": "PENDENTE",<br>
            "page": 0,<br>
            "size": 5,<br>
            "sort": ["id"]<br>
          }<br>

  GET /topicos/{id}<br>
    Retorna os detalhes de um tópico específico pelo ID e suas respostas cadastradas <br>

  PUT /topicos/{id}<br>
    Atualiza as informações de um tópico existente.<br>

  DELETE /topicos/{id}<br>
    Marca um tópico e suas respostas associadas como inativos.<br>

  Post /Respostas<br>
  Endpoints dedicados para cadastrar resposta de um determinado tópico.<br>

Documentação da API<br>
A documentação detalhada dos endpoints está disponível nos seguintes URLs:<br>
Swagger UI: http://localhost:8080/swagger-ui.html<br>
API Docs (OpenAPI): http://localhost:8080/v3/api-docs/<br>
Esses pontos estão configurados para acesso público, permitindo que qualquer usuário visualize a estrutura e utilize as ferramentas de teste da API.<br>
<h1 align="center"> Estrutura Principal </h1><br>
-*Controle de Segurança<br>*

Utiliza filtros personalizados para autenticação via JWT, garantindo acesso seguro aos endpoints.
Configuração de segurança que desabilita CSRF e aplica autenticação baseada em tokens.
Modelo de Dados

Tópicos: Cada tópico possui título, mensagem, data de criação, status padrão ("PENDENTE"), e um estado ativo (true por padrão).
Respostas: Relacionadas a um tópico específico, também podem ser marcadas como inativas.
Fluxo de Atualização e Exclusão

Atualizações de tópicos são flexíveis e somente os campos enviados no corpo da requisição são alterados.
Exclusão lógica de tópicos e respostas associadas para manter a integridade dos dados.
Autenticação JWT

Geração de tokens com validade de 2 horas, utilizando a biblioteca java-jwt.
Validação dos tokens para identificar e autenticar o usuário em cada requisição.

- *Requisitos*<br>
  Java 17+
  Spring Boot 3.0+
  MySQL ou outro banco de dados compatível.
  Dependências Maven:
  spring-boot-starter-data-jpa
  spring-boot-starter-web
  spring-boot-starter-security
  java-jwt
  spring-boot-starter-validation


<h1 align="center"> Parceiros Educacionais</h1>

Este curso é oferecido por:   
 
- <img class="imagem" src="src/main/java/br/com/alura/Livros/Assets/Logo Alura.png" alt="logo Alura" >          **Alura**: Reconhecida instituição de ensino em tecnologia, especializada em cursos de desenvolvimento de software e outras áreas tecnológicas.
  
- <img class="imagem" src="src/main/java/br/com/alura/Livros/Assets/logo one.webp"  alt="logo Alura" >  **Oracle Next Education**: Programa da Oracle que visa capacitar profissionais para o mercado de tecnologia com treinamento avançado e recursos educacionais.

Juntos, esses parceiros proporcionam um curso abrangente e atualizado, preparando os alunos para se destacarem na área de desenvolvimento e tecnologia.

<h1 align="center"> Direitos Autorais</h1>

- ©  2024 Kleber Alves de Lima. Todos os direitos reservados.

<h1 align="center"> Contato</h1>

Para dúvidas, sugestões ou parcerias, entre em contato:

- Nome........... : Kleber Alves de Lima
- E-mail........... : klebelima@hotmail.com
- Linkedin..... : https://www.linkedin.com/in/kleber-alves-desenvolvedor/
- Github........ : https://github.com/Kleber-Alves-Lima

