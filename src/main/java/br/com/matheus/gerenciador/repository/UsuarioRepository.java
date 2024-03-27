package br.com.matheus.gerenciador.repository;

import br.com.matheus.gerenciador.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
    Usuario findByEmail(String email);

    @Override
    Optional<Usuario> findById(Long id);
}
