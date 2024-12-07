package br.com.alura.ForumHub.Domain.Topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data_criacao,
        Long autor_id,
        String status,
        String curso,

        Boolean ativo) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData_criacao(), topico.getUsuario().getId(),
                topico.getStatus(), topico.getCurso(),  topico.getAtivo());
    }


}