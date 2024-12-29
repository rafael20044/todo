package dev.rafaelbarragan.todo.domain.tarea.dto;


import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TareaCrear(

        @NotNull
        Long creador,

        @NotNull
        String titulo,

        @NotNull
        String descripcion,

        List<Long> etiquetas_id,

        Integer dia_limite
) {
}
