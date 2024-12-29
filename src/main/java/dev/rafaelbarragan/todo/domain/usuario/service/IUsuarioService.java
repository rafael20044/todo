package dev.rafaelbarragan.todo.domain.usuario.service;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import dev.rafaelbarragan.todo.domain.usuario.dto.*;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {

    UsuarioRespuesta crear(UsuarioCrear crear);

    UsuarioBuscar buscar(Long id);

    Usuario buscarEntidad(Long id);

    void agregarTarea(Tarea tarea, Usuario usuario);

    Page<UsuarioPage> buscarTodos(Pageable pageable);

    UsuarioRespuesta editar(UsuarioEditar editar);

    void eliminarPermanente(Long id);
}
