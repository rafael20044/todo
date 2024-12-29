package dev.rafaelbarragan.todo.domain.usuario.service;

import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioCrear;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioRespuesta;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import dev.rafaelbarragan.todo.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UsuarioRespuesta crear(UsuarioCrear crear) {
        Optional<Usuario> usuarioOptional = repository.findByCorreo(crear.correo());
        if (usuarioOptional.isEmpty()) {
            String pass = bCryptPasswordEncoder.encode(crear.contrasena());
            Usuario usuario = new Usuario(crear, pass);
            repository.save(usuario);
            return new UsuarioRespuesta(usuario);
        }
        throw new RuntimeException("Usuario existente");
    }
}
