package br.com.alura.ForumHub.Domain.Topico.Resposta;

import br.com.alura.ForumHub.Domain.Topico.Topico;

import br.com.alura.ForumHub.Domain.Topico.Resposta.DadosResposta;
import br.com.alura.ForumHub.Domain.Topico.Resposta.DadosRespostaConsulta;
import br.com.alura.ForumHub.Domain.Usuario.Usuario;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;


public record DadosDetalhamentoCadastro (
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data_criacao,
        Long autor_id,
        String status,
        String curso,
        Boolean ativo ) {

    public DadosDetalhamentoCadastro(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData_criacao(),topico.getUsuario().getId(),
                topico.getStatus(), topico.getCurso(),topico.getAtivo());

    }

}