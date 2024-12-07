package br.com.alura.ForumHub.Domain.Topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("SELECT t FROM Topico t WHERE  LOWER(t.status) = LOWER(:status) and t.ativo =true ")
    Page<Topico> findAllByStatus(@Param("status") String status, Pageable paginacao);

    @Query("SELECT t FROM Topico t LEFT JOIN FETCH t.respostas WHERE t.id = :id AND t.ativo = true")
    Topico localizaTopicoEResposta(@Param("id") Long id);

    @Query("SELECT t FROM Topico t WHERE  t.id = :id and t.ativo =true ")
    Topico localizaTopicoERespostaExcluir(@Param("id") Long id);
}
