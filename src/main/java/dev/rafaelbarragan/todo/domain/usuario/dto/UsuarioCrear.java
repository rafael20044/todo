package dev.rafaelbarragan.todo.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UsuarioCrear(

        @NotNull
        String nombre,

        @NotNull
        @Email
        String correo,

        @NotNull
        String contrasena
) {
}
