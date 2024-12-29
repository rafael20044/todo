package dev.rafaelbarragan.todo.domain.tarea.dto;


import jakarta.validation.constraints.NotNull;

public record TareaCrear(

        @NotNull
        Long creador,

        @NotNull
        String titulo,

        @NotNull
        String descripcion,

        Integer dia_limite
) {
}
