package br.com.alura.ForumHub.Domain.Usuario;


public record DadosDetalhamentoUsuario(
        Long id,
        String email,
        String senha,
        String nome
){
    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getNome() );
    }
}