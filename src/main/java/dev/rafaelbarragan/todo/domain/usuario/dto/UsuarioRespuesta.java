package dev.rafaelbarragan.todo.domain.usuario.dto;

import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;

public record UsuarioRespuesta(

        Long id,

        String nombre,

        String correo,

        String contrasena
) {
    public UsuarioRespuesta(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getContrasena());
    }
}
