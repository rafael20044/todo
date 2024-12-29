package dev.rafaelbarragan.todo.domain.tarea.service;

import dev.rafaelbarragan.todo.domain.tarea.dto.TareaCrear;
import dev.rafaelbarragan.todo.domain.tarea.dto.TareaRespuesta;
import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import dev.rafaelbarragan.todo.domain.tarea.repository.TareaRepository;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import dev.rafaelbarragan.todo.domain.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService implements ITareaService{

    private final TareaRepository repository;
    private final UsuarioService usuarioService;

    @Autowired
    public TareaService(TareaRepository repository, UsuarioService usuarioService){
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    @Override
    public TareaRespuesta crear(TareaCrear crear) {
        Usuario usuario = usuarioService.buscarEntidad(crear.creador());
        Tarea tarea = new Tarea(crear, usuario);
        usuarioService.agregarTarea(tarea, usuario);
        repository.save(tarea);
        return new TareaRespuesta(tarea);
    }
}
