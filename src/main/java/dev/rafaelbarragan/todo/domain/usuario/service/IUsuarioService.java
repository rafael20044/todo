package dev.rafaelbarragan.todo.domain.usuario.service;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioBuscar;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioCrear;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioRespuesta;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;

public interface IUsuarioService {

    UsuarioRespuesta crear(UsuarioCrear crear);

    UsuarioBuscar buscar(Long id);

    Usuario buscarEntidad(Long id);

    void agregarTarea(Tarea tarea, Usuario usuario);
}
