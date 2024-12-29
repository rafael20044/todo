package dev.rafaelbarragan.todo.domain.tarea.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TareaEditar(

        @NotNull
        Long id,

        String titulo,

        String descripcion,

        Integer dia_vencimiento,

        List<Long> etiquetas
) {
}
