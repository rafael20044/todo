package dev.rafaelbarragan.todo.controller;

import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaCrear;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaRespuesta;
import dev.rafaelbarragan.todo.domain.etiqueta.service.EtiquetaService;
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
}
