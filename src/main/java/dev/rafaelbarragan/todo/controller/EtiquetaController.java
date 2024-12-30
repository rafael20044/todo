package dev.rafaelbarragan.todo.controller;

import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaBuscar;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaCrear;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaEditar;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaRespuesta;
import dev.rafaelbarragan.todo.domain.etiqueta.service.EtiquetaService;
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
@RequestMapping("/etiqueta")
public class EtiquetaController {

    private final EtiquetaService service;

    @Autowired
    public EtiquetaController(EtiquetaService service){
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EtiquetaRespuesta> crear(@RequestBody @Valid EtiquetaCrear crear,
                                                   UriComponentsBuilder builder){
        EtiquetaRespuesta respuesta = service.crear(crear);
        URI uri = builder.path("/etiqueta/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<EtiquetaBuscar> buscar(@PathVariable Long id){
        EtiquetaBuscar buscar = service.buscar(id);
        return ResponseEntity.ok(buscar);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<EtiquetaBuscar>> buscarTodos(Pageable pageable){
        Page<EtiquetaBuscar> lista = service.buscarTodos(pageable);
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<EtiquetaRespuesta> editar(@RequestBody @Valid EtiquetaEditar editar){
        EtiquetaRespuesta respuesta = service.editar(editar);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/perma/{id}")
    @Transactional
    public ResponseEntity<Void> borrar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
