package dev.rafaelbarragan.todo.exception;

public class ExistenteException extends RuntimeException {
    public ExistenteException(String message) {
        super(message);
    }
}
