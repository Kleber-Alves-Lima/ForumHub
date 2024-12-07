package br.com.alura.ForumHub.Domain.Topico;


import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        LocalDateTime data_criacao,
        @NotNull
        Long autor_id,
        @NotNull
        String curso

) {
}