package dev.rafaelbarragan.todo.domain.etiqueta.dto;

import jakarta.validation.constraints.NotNull;

public record EtiquetaEditar(
        @NotNull
        Long id,

        String nombre
) {
}
