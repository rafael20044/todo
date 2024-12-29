package dev.rafaelbarragan.todo.domain.etiqueta.dto;

import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;

public record EtiquetaRespuesta(
        Long id,
        String nombre
) {
    public EtiquetaRespuesta(Etiqueta etiqueta) {
        this(etiqueta.getId(), etiqueta.getNombre());
    }
}
