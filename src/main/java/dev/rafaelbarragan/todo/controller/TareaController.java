package dev.rafaelbarragan.todo.controller;

import dev.rafaelbarragan.todo.domain.tarea.dto.*;
import dev.rafaelbarragan.todo.domain.tarea.service.TareaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    private final TareaService service;

    @Autowired
    public TareaController(TareaService service){
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TareaRespuesta> crear(@RequestBody @Valid TareaCrear crear, UriComponentsBuilder builder){
        TareaRespuesta respuesta = service.crear(crear);
        URI uri = builder.path("/tarea/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<TareaBuscar> buscar(@PathVariable Long id){
        TareaBuscar buscar = service.buscar(id);
        return ResponseEntity.ok(buscar);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<TareaPage>> buscarTodos(Pageable pageable){
        Page<TareaPage> lista = service.buscarTodos(pageable);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/hoy/{id}")
    @Transactional
    public ResponseEntity<Page<TareaPage>> buscarTodosHoy(Pageable pageable, @PathVariable Long id){
        var lista = service.buscarTodosHoy(pageable, id);
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TareaRespuesta> editar(@RequestBody TareaEditar editar){
        TareaRespuesta respuesta = service.editar(editar);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/perma/{id}")
    @Transactional
    public ResponseEntity<String> borrarPerma(@PathVariable Long id){
        String mensaje = service.borraPerma(id);
        return ResponseEntity.ok(mensaje);
    }

    @PutMapping("/terminar/{id}")
    @Transactional
    public ResponseEntity<TareaRespuesta> terminar(@PathVariable Long id){
        TareaRespuesta respuesta = service.terminar(id);
        return ResponseEntity.ok(respuesta);
    }
}
