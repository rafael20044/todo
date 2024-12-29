package dev.rafaelbarragan.todo.domain.tarea.dto;

import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;

public record TareaCreador(
        Long id,
        String nombre
) {
    public TareaCreador(Usuario creador) {
        this(creador.getId(), creador.getNombre());
    }
}
