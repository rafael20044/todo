package dev.rafaelbarragan.todo.domain.tarea.dto;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;

import java.time.LocalDateTime;

public record TareaRespuesta(

        Long id,
        TareaCreador creador,
        String titulo,
        String descripcion,
        LocalDateTime fecha_creacion,
        LocalDateTime fecha_vencimiento,
        boolean completado
) {
    public TareaRespuesta(Tarea tarea) {
        this(tarea.getId(), new TareaCreador(tarea.getCreador()), tarea.getTitulo(), tarea.getDescripcion(),
                tarea.getFechaCreacion(), tarea.getFechaVencimiento(), tarea.isCompletada());
    }
}
