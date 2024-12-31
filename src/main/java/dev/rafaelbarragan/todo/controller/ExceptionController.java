package dev.rafaelbarragan.todo.controller;

import dev.rafaelbarragan.todo.exception.ExistenteException;
import dev.rafaelbarragan.todo.exception.Mensaje;
import dev.rafaelbarragan.todo.exception.NoEncontradoException;
import dev.rafaelbarragan.todo.exception.TokenException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoEncontradoException.class)
    public ResponseEntity<Mensaje> errorNoEncontrado(NoEncontradoException e){
        Mensaje mensaje = new Mensaje(e.getMessage());
        return ResponseEntity.status(404).body(mensaje);
    }

    @ExceptionHandler(ExistenteException.class)
    public ResponseEntity<Mensaje> errorExistencia(ExistenteException e){
        Mensaje mensaje = new Mensaje(e.getMessage());
        return ResponseEntity.badRequest().body(mensaje);
    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<Mensaje> errorGenerarToken(TokenException e){
        Mensaje mensaje = new Mensaje(e.getMessage());
        return ResponseEntity.ok(mensaje);
    }
}
