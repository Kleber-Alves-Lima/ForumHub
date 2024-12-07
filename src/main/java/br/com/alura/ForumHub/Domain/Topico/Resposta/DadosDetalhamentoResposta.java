package br.com.alura.ForumHub.Domain.Topico.Resposta;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(Long id,
                                        Long topico_id,
                                        Long autor_id,
                                        Boolean ativo,
                                        LocalDateTime data_resposta,
                                        String resposta
) {
    public DadosDetalhamentoResposta(Resposta resposta) {
        this(resposta.getId(),
                resposta.getTopico().getId(),
                resposta.getUsuario().getId(),
                resposta.getAtivo(),
                resposta.getData_resposta(),
                resposta.getResposta());
        }
}
