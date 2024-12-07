package br.com.alura.ForumHub.Controller;

import br.com.alura.ForumHub.Domain.Topico.Resposta.DadosDetalhamentoResposta;
import br.com.alura.ForumHub.Domain.Topico.Resposta.DadosResposta;
import br.com.alura.ForumHub.Domain.Topico.Resposta.Resposta;
import br.com.alura.ForumHub.Domain.Topico.Resposta.RespostaRespository;
import br.com.alura.ForumHub.Domain.Topico.Topico;
import br.com.alura.ForumHub.Domain.Topico.TopicoRepository;
import br.com.alura.ForumHub.Domain.Usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {
    @Autowired
    private RespostaRespository repository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosResposta dados){
        Resposta resposta = new Resposta(dados, topicoRepository, usuarioRepository);
        repository.save(resposta);
        Topico topico = topicoRepository.findById(dados.topico_id())
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado"));
        if (topico.getStatus() != "RESPONDIDO" ) {
            topico.setStatus("RESPONDIDO");
            topicoRepository.save(topico);
        }
        return ResponseEntity.ok(new DadosDetalhamentoResposta(resposta));
    }

}