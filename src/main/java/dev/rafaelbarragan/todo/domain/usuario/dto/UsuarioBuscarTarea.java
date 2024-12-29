package dev.rafaelbarragan.todo.domain.usuario.dto;

import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaRespuesta;
import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;

import java.time.LocalDateTime;
import java.util.List;

public record UsuarioBuscarTarea(
        Long id,
        String titulo,
        String descripcion,
        LocalDateTime fecha_creacion,
        LocalDateTime fecha_vencimiento,
        boolean completado,
        List<EtiquetaRespuesta> etiquetas
) {

    public UsuarioBuscarTarea(Tarea tarea){
        this(tarea.getId(), tarea.getTitulo(), tarea.getDescripcion(), tarea.getFechaCreacion(),
                tarea.getFechaVencimiento(), tarea.isCompletada(),
                tarea.getEtiquetas().stream().map(EtiquetaRespuesta::new).toList());
    }
}
