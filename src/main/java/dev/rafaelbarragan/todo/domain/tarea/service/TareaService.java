package dev.rafaelbarragan.todo.domain.tarea.service;

import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;
import dev.rafaelbarragan.todo.domain.etiqueta.service.EtiquetaService;
import dev.rafaelbarragan.todo.domain.tarea.dto.*;
import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import dev.rafaelbarragan.todo.domain.tarea.repository.TareaRepository;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import dev.rafaelbarragan.todo.domain.usuario.service.UsuarioService;
import dev.rafaelbarragan.todo.exception.NoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        repository.save(tarea);
        return new TareaRespuesta(tarea);
    }

    @Override
    public TareaBuscar buscar(Long id) {
        Tarea tarea = buscarEntidad(id);
        return new TareaBuscar(tarea);
    }

    @Override
    public Page<TareaPage> buscarTodos(Pageable pageable) {
        return repository.findAll(pageable).map(TareaPage::new);
    }

    @Override
    public TareaRespuesta editar(TareaEditar editar) {
        Tarea tarea = buscarEntidad(editar.id());
        List<Etiqueta> etiquetas = etiquetaService.bsucarEtiquetas(editar.etiquetas());
        tarea.editar(editar, etiquetas);
        repository.save(tarea);
        return new TareaRespuesta(tarea);
    }

    @Override
    public Tarea buscarEntidad(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoEncontradoException("Tarea no existente"));
    }

    @Override
    public String borraPerma(Long id) {
        repository.deleteById(id);
        return "La tarea con el id " + id + " fue eliminada de manera permanente";
    }

    @Override
    public TareaRespuesta terminar(Long id) {
        Tarea tarea = buscarEntidad(id);
        tarea.completar();
        return new TareaRespuesta(tarea);
    }
}
