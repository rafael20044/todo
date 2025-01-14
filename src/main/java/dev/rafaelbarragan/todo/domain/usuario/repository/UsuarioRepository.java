package dev.rafaelbarragan.todo.domain.usuario.repository;

import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

    Optional<UserDetails> findByNombre(String nombre);
}
