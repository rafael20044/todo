package dev.rafaelbarragan.todo.domain.etiqueta.dto;

import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;

public record EtiquetaBuscar(
        Long id,
        String nombre
) {
    public EtiquetaBuscar(Etiqueta etiqueta) {
        this(etiqueta.getId(), etiqueta.getNombre());
    }
}
