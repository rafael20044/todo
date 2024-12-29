package dev.rafaelbarragan.todo.domain.usuario.service;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import dev.rafaelbarragan.todo.domain.usuario.dto.*;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import dev.rafaelbarragan.todo.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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

    @Override
    public UsuarioBuscar buscar(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(()->
                new RuntimeException("Usuario no existente"));
        return new UsuarioBuscar(usuario);
    }

    @Override
    public Usuario buscarEntidad(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no existente"));
    }

    @Override
    public void agregarTarea(Tarea tarea, Usuario usuario) {
        usuario.agregarTarea(tarea);
        repository.save(usuario);
    }

    @Override
    public Page<UsuarioPage> buscarTodos(Pageable pageable) {
        return repository.findAll(pageable).map(UsuarioPage::new);
    }

    @Override
    public UsuarioRespuesta editar(UsuarioEditar editar) {
        Usuario usuario = buscarEntidad(editar.id());
        String pass = editar.contrasena() != null ? bCryptPasswordEncoder.encode(editar.contrasena()) : null;
        usuario.editar(editar, pass);
        repository.save(usuario);
        return new UsuarioRespuesta(usuario);
    }

    @Override
    public void eliminarPermanente(Long id) {
        repository.deleteById(id);
    }
}
