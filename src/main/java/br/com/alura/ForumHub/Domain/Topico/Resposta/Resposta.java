package br.com.alura.ForumHub.Domain.Topico.Resposta;

import br.com.alura.ForumHub.Domain.Topico.Topico;
import br.com.alura.ForumHub.Domain.Topico.TopicoRepository;
import br.com.alura.ForumHub.Domain.Usuario.Usuario;
import br.com.alura.ForumHub.Domain.Usuario.UsuarioRepository;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario usuario;

    private LocalDateTime data_resposta;

    private String resposta;
    private Boolean ativo;

    public Resposta(DadosResposta dados, TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {
        // Busca o Topico no banco de dados com o ID fornecido em dados.topico_id()
        this.topico = topicoRepository.findById(dados.topico_id())
                .orElseThrow(() -> new IllegalArgumentException("Topico não encontrado"));

        // Busca o Usuario no banco de dados com o ID fornecido em dados.autor_id()
        this.usuario = usuarioRepository.findById(dados.autor_id())
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));

        // Atribuindo os outros dados diretamente
        this.data_resposta = dados.data_resposta();
        this.resposta = dados.resposta();
        this.ativo = dados.ativo();
    }

}