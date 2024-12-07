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

- ** Sistema de uma API completa para gerenciamento de tópicos e respostas.**

Este projeto FórumHub  foi desenvolvido como parte do **Challenge Back End**,uma iniciativa da [**Alura**](https://www.alura.com.br/) em parceria com o programa [**Oracle Next Education**](https://www.oracle.com/br/education/oracle-next-education/). O sistema foi projetado para Facilitar o gerenciamento de discussões e soluções. povoando o banco de dados   com conteúdo relevante. 

O desafio proposto pelo curso de desenvolvimento de sistemas visou não apenas o domínio técnico, mas também a compreensão de conceitos fundamentais . Este projeto reflete o comprometimento com a inovação e a excelência técnica, aplicando conhecimentos adquiridos ao longo do curso . 

<h1 align="center"> Funcionalidades </h1><br>

- *Descrição* <br>
A FórumHub API é uma API RESTful desenvolvida com Spring Boot e JPA, projetada para facilitar a interação em fóruns de discussão. Ela permite o gerenciamento de tópicos de dúvidas e respostas, com recursos robustos de autenticação e segurança, incluindo a geração e validação de tokens JWT.
Com endpoints organizados e funcionalidades práticas, o FórumHub é ideal para plataformas de compartilhamento de conhecimento. <br>

- *A API disponibiliza os seguintes recursos:*<br>

Autenticação

POST /login
Realiza a autenticação do usuário e retorna um token JWT para acesso aos recursos protegidos.

Tópicos
POST /topicos
Cria um novo tópico de discussão.

GET /topicos
Lista todos os tópicos disponíveis.

GET /topicos/{id}
Retorna os detalhes de um tópico específico pelo ID.

PUT /topicos/{id}
Atualiza as informações de um tópico existente.

DELETE /topicos/{id}
Marca um tópico e suas respostas associadas como inativos.

Respostas
Endpoints dedicados para cadastrar resposta de um determinado tópico.



<h3>Menu de Opções</h3>

***************************************************<br>
1  - Buscar Livro pelo título<br>
2  - Listar livros registrados<br>
3  - Listar autores registrados<br>
4  - Listar autores vivos em um determinado ano<br>
5  - Listar livros em um determinado idíoma<br>
0 - Sair<br>

***************************************************<br>

Opção .: 2<br>

--------------------- LIVRO ---------------------<br>
Título              : Emma<br>
Autor               : Austen, Jane<br>
idioma              : en<br>
Número de downloads : 5798<br>
--------------------------------------------------<br>

Opção .: 3<br>
Austen, Jane<br>
Machado de Assis<br>
Melville, Herman<br>
Kafka, Franz<br>
Homer<br>
Cervantes Saavedra, Miguel de<br>

- *Estrutura Principal*<br>
  A classe Principal gerencia o sistema, exibindo o menu de opções e interagindo com o banco de dados e a API. Ela inclui:<br><br>

  ENDERECO: URL da API para consulta de livros.<br>
  ConsumoAPI: Classe que lida com o consumo de dados da API.<br>
  ConverteDados: Classe para converter e processar dados JSON da API.<br>
  LivroRepository e AutorRepository: Interfaces para acesso e manipulação dos dados no banco.<br>




- *Requisitos*<br>
  Java: JDK 11 ou superior <br>
  Maven: Para gerenciamento de dependências<br>
  Banco de Dados: (Especifique o banco usado, ex.: MySQL, PostgreSQL)<br>
  API Gutendex: O sistema consome dados da API pública Gutendex (https://gutendex.com).<br>


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

