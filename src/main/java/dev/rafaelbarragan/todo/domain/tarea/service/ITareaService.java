package dev.rafaelbarragan.todo.domain.tarea.service;

import dev.rafaelbarragan.todo.domain.tarea.dto.TareaCrear;
import dev.rafaelbarragan.todo.domain.tarea.dto.TareaRespuesta;

public interface ITareaService {

    TareaRespuesta crear(TareaCrear crear);
}
