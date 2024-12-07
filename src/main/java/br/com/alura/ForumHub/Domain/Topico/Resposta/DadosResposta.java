package br.com.alura.ForumHub.Domain.Topico.Resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosResposta(
        @NotNull
        long topico_id,
        @NotNull
        Long autor_id,
        @NotNull
        Boolean ativo,
        @NotNull
        LocalDateTime data_resposta,
        @NotBlank
        String resposta

) {
}
