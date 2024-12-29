package dev.rafaelbarragan.todo.domain.usuario.dto;

import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;

import java.time.LocalDateTime;

public record UsuarioPage(
        Long id,
        String nombre,
        String correo,
        LocalDateTime fecha_creacion
) {

    public UsuarioPage(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getFechaCreacion());
    }
}
