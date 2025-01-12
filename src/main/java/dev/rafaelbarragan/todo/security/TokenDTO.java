package dev.rafaelbarragan.todo.security;

public record TokenDTO(
        String token,
        Long id
) {
}
