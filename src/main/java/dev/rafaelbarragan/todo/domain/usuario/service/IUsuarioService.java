package dev.rafaelbarragan.todo.domain.usuario.service;

import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioCrear;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioRespuesta;

public interface IUsuarioService {

    UsuarioRespuesta crear(UsuarioCrear crear);
}
