package br.com.alura.ForumHub.Domain.Topico.Resposta;

import br.com.alura.ForumHub.Domain.Usuario.Usuario;

import java.time.LocalDateTime;
public record DadosRespostaConsulta(    Long autor_id,
                                        LocalDateTime data_resposta,
                                        String resposta
) {
    public DadosRespostaConsulta(Resposta resposta) {
        this(   resposta.getUsuario().getId(),
                resposta.getData_resposta(),
                resposta.getResposta());
    }
}

