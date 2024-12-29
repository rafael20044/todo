package dev.rafaelbarragan.todo.domain.usuario.dto;

import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record UsuarioBuscar(
        Long id,
        String nombre,
        String correo,
        LocalDateTime fecha_creacion,
        List<UsuarioBuscarTarea> tareas
) {
    public UsuarioBuscar(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getFechaCreacion(),
                usuario.getTareas().stream().map(UsuarioBuscarTarea::new).toList());
    }
}
