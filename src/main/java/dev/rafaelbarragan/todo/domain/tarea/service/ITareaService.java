package dev.rafaelbarragan.todo.domain.tarea.service;

import dev.rafaelbarragan.todo.domain.tarea.dto.*;
import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITareaService {

    TareaRespuesta crear(TareaCrear crear);

    TareaBuscar buscar(Long id);

    Page<TareaPage> buscarTodos(Pageable pageable);

    TareaRespuesta editar(TareaEditar editar);

    Tarea buscarEntidad(Long id);

    String borraPerma(Long id);

    TareaRespuesta terminar(Long id);
}
