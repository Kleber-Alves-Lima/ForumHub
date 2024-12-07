package br.com.alura.ForumHub.Domain.Topico;

import br.com.alura.ForumHub.Domain.Topico.Resposta.Resposta;
import br.com.alura.ForumHub.Domain.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data_criacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario usuario;

    private String status = "PENDENTE";
    private String curso;
    //  @Column(columnDefinition = "BIT")
    private Boolean ativo = true;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resposta> respostas;

    public List<Resposta> getRespostas() {
        return respostas;}

    public Topico(DadosCadastroTopico dados) {
       this.titulo = dados.titulo();
       this.mensagem = dados.mensagem();
       this.data_criacao = dados.data_criacao();
       this.usuario = new Usuario(dados.autor_id());
       this.curso = dados.curso();
       this.respostas = getRespostas();
    }

    public void excluir() {
        this.ativo = false;
        if (this.respostas != null) {
            this.respostas.forEach(resposta -> resposta.setAtivo(false));
        }
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {

        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.curso() != null) {
            this.curso = dados.curso();
        }
    }
}
