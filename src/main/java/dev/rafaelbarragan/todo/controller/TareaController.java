package dev.rafaelbarragan.todo.controller;

import dev.rafaelbarragan.todo.domain.tarea.dto.TareaCrear;
import dev.rafaelbarragan.todo.domain.tarea.dto.TareaRespuesta;
import dev.rafaelbarragan.todo.domain.tarea.service.TareaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
