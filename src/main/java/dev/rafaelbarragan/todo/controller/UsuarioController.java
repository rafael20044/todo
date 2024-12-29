package dev.rafaelbarragan.todo.controller;

import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioBuscar;
import dev.rafaelbarragan.todo.domain.usuario.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioBuscar> buscar(@PathVariable Long id){
        UsuarioBuscar buscar = service.buscar(id);
        return ResponseEntity.ok(buscar);
    }
}
