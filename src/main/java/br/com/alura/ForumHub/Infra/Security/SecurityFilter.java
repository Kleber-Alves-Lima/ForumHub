package br.com.alura.ForumHub.Infra.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.com.alura.ForumHub.Domain.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

      //recuperar token do cabeçalho
      var tokenJWT = recuperarToken(request);

      if (tokenJWT != null) {
          var subject = tokenService.getSubject(tokenJWT);
          var usuario = repository.findByEmail((subject));
          var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(authentication);
      }
      filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ","");
        }
      return null;


    }
}
