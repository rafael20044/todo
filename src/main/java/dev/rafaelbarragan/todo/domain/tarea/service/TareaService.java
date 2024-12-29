package dev.rafaelbarragan.todo.domain.tarea.service;

import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;
import dev.rafaelbarragan.todo.domain.etiqueta.service.EtiquetaService;
import dev.rafaelbarragan.todo.domain.tarea.dto.TareaCrear;
import dev.rafaelbarragan.todo.domain.tarea.dto.TareaRespuesta;
import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import dev.rafaelbarragan.todo.domain.tarea.repository.TareaRepository;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import dev.rafaelbarragan.todo.domain.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService implements ITareaService{

    private final TareaRepository repository;
    private final UsuarioService usuarioService;
    private final EtiquetaService etiquetaService;

    @Autowired
    public TareaService(TareaRepository repository, UsuarioService usuarioService, EtiquetaService etiquetaService){
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.etiquetaService = etiquetaService;
    }

    @Override
    public TareaRespuesta crear(TareaCrear crear) {
        Usuario usuario = usuarioService.buscarEntidad(crear.creador());
        List<Etiqueta> etiquetas = etiquetaService.bsucarEtiquetas(crear.etiquetas_id());
        Tarea tarea = new Tarea(crear, usuario, etiquetas);
        usuarioService.agregarTarea(tarea, usuario);
        repository.save(tarea);
        return new TareaRespuesta(tarea);
    }
}
