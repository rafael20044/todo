package dev.rafaelbarragan.todo.domain.tarea.repository;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
