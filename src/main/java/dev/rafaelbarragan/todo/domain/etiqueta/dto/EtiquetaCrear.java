package dev.rafaelbarragan.todo.domain.etiqueta.dto;

import jakarta.validation.constraints.NotNull;

public record EtiquetaCrear(
        @NotNull
        String nombre
) {
}
