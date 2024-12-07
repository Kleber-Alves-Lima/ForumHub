package br.com.alura.ForumHub.Domain.Topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        String titulo,
        String mensagem,
        String curso

) {
}
