package br.com.matheus.gerenciador.repository;

import br.com.matheus.gerenciador.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByUsername(String username);

    List<Usuario> findAllByNome(String nome);

    Object findByEmail(String email);
}
