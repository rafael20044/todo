package dev.rafaelbarragan.todo.controller;

import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioBuscar;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioEditar;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioPage;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioRespuesta;
import dev.rafaelbarragan.todo.domain.usuario.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @Transactional
    public ResponseEntity<Page<UsuarioPage>> buscarTodos(Pageable pageable){
        Page<UsuarioPage> buscar = service.buscarTodos(pageable);
        return ResponseEntity.ok(buscar);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UsuarioRespuesta> editar(@RequestBody UsuarioEditar editar){
        UsuarioRespuesta respuesta = service.editar(editar);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("perma/{id}")
    @Transactional
    public ResponseEntity<Void> borarPermanente(@PathVariable Long id){
        service.eliminarPermanente(id);
        return ResponseEntity.ok().build();
    }
}
