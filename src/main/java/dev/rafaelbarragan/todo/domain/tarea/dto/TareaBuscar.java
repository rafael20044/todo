package dev.rafaelbarragan.todo.domain.tarea.dto;

import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaRespuesta;
import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;

import java.time.LocalDateTime;
import java.util.List;

public record TareaBuscar(
        Long id,
        TareaCreador creador,
        String titulo,
        String descripcion,
        LocalDateTime fecha_creacion,
        LocalDateTime fecha_vencimiento,
        boolean completado,
        List<EtiquetaRespuesta> etiquetas
) {
    public TareaBuscar(Tarea tarea) {
        this(tarea.getId(), new TareaCreador(tarea.getCreador()), tarea.getTitulo(), tarea.getDescripcion(),
                tarea.getFechaCreacion(), tarea.getFechaVencimiento(), tarea.isCompletada(),
                tarea.getEtiquetas().stream().map(EtiquetaRespuesta::new).toList());
    }
}
