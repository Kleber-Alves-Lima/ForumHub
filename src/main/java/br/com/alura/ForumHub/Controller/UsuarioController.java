package br.com.alura.ForumHub.Controller;


import br.com.alura.ForumHub.Domain.Usuario.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosAutenticacao dados, UriComponentsBuilder uriBuilder){
        var senhaCodificada = passwordEncoder.encode(dados.senha());
        var dadosAtualizados = new DadosAutenticacao(dados.email(),senhaCodificada, dados.nome() );

        var usuario =new Usuario(dadosAtualizados);

        repository.save(usuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }
}
