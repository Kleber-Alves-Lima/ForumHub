package br.com.alura.ForumHub.Controller;

import br.com.alura.ForumHub.Domain.Topico.*;
import br.com.alura.ForumHub.Domain.Topico.Resposta.DadosDetalhamentoCadastro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

    @RestController
    @RequestMapping("/topicos")
    @SecurityRequirement(name = "bearer-key")
    public class TopicoController {

        @Autowired
        private TopicoRepository repository;

        @PostMapping
        @Transactional
        public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
            var topico =new Topico(dados);
            System.out.println(dados);
            System.out.println(dados.autor_id());
            repository.save(topico);
            var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
            return  ResponseEntity.created(uri).body(new DadosDetalhamentoCadastro(topico));
        }

        @Operation(summary = "Listar tópicos", description = "Lista os tópicos com paginação e ordenação. Campos válidos para ordenação: id, titulo, status.")
        @GetMapping
        public ResponseEntity <Page<DadosListagemTopico>>listar(@RequestParam(required = false) String status,
                                                                @PageableDefault(sort = "id", direction = Sort.Direction.ASC)
                                                                @Parameter(description = "Campos válidos para ordenação: id, titulo, status", example = "id")
                                                                Pageable paginacao) {
            String statusFiltrado = (status != null) ? status : "PENDENTE";
            Page<DadosListagemTopico>  page = repository.findAllByStatus(statusFiltrado, paginacao).map(DadosListagemTopico::new);
            return ResponseEntity.ok(page);

        }
        @GetMapping("/{id}")
        public ResponseEntity detalhar(@PathVariable Long id){ //metodo ReponseEntity e para trabalhar as resposta ao front end
            //Topico topico = repository.getReferenceById(id);
            Topico topico = repository.localizaTopicoEResposta(id);
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        }

        @DeleteMapping("/{id}")
        @Transactional
        public ResponseEntity<Void> Excluir(@PathVariable Long id){ //metodo ReponseEntity e para trabalhar as resposta ao front end
            Topico topico = repository.localizaTopicoERespostaExcluir(id);
            if (topico == null) {
                return ResponseEntity.notFound().build();
            }
            topico.excluir();
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
        @Transactional
        public ResponseEntity Atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados){
            System.out.println("*********************************");
            System.out.println(id);
            Topico topico = repository.getReferenceById(id);
            topico.atualizarInformacoes(dados);
            //Aqui automaticamente ja e gravado no banco  com update sem ter necessidade de via codigo informar pois a JPA ja faz sozinha
            return ResponseEntity.ok(new DadosDetalhamentoCadastro(topico));
        }

    }
