package dev.rafaelbarragan.todo.domain.usuario.dto;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;

import java.time.LocalDateTime;

public record UsuarioBuscarTarea(
        Long id,
        String titulo,
        String descripcion,
        LocalDateTime fecha_creacion,
        LocalDateTime fecha_vencimiento,
        boolean completado
) {

    public UsuarioBuscarTarea(Tarea tarea){
        this(tarea.getId(), tarea.getTitulo(), tarea.getDescripcion(), tarea.getFechaCreacion(),
                tarea.getFechaVencimiento(), tarea.isCompletada());
    }
}
