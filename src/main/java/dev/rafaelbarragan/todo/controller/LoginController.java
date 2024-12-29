package dev.rafaelbarragan.todo.controller;

import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioCrear;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioRespuesta;
import dev.rafaelbarragan.todo.domain.usuario.service.UsuarioService;
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
@RequestMapping("/login")
public class LoginController {

    private final UsuarioService service;

    @Autowired
    public LoginController(UsuarioService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioRespuesta> crear(@RequestBody @Valid UsuarioCrear crear,
                                                  UriComponentsBuilder builder){
        UsuarioRespuesta respuesta = service.crear(crear);
        URI uri = builder.path("/usuario/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }
}
