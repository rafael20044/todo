package dev.rafaelbarragan.todo.exception;

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
}
