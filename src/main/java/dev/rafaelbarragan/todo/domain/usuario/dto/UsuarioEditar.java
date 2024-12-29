package dev.rafaelbarragan.todo.domain.usuario.dto;

public record UsuarioEditar(
        Long id,

        String nombre,

        String correo,

        String contrasena
) {
}
