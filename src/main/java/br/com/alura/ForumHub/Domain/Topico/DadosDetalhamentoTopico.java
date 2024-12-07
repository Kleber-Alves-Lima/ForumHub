package br.com.alura.ForumHub.Domain.Topico;

import br.com.alura.ForumHub.Domain.Topico.Resposta.DadosResposta;
import br.com.alura.ForumHub.Domain.Topico.Resposta.DadosRespostaConsulta;
import br.com.alura.ForumHub.Domain.Usuario.Usuario;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalhamentoTopico(
    Long id,
    String titulo,
    String mensagem,
    LocalDateTime data_criacao,
    Long autor_id,
    String status,
    String curso,
    Boolean topico,
    List<DadosRespostaConsulta> respostas) {
    public DadosDetalhamentoTopico(Topico topico){
         this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData_criacao(), topico.getUsuario().getId(),
          topico.getStatus(), topico.getCurso(), topico.getAtivo(),
                 topico.getRespostas().stream().map(DadosRespostaConsulta::new).toList());
    }

}
