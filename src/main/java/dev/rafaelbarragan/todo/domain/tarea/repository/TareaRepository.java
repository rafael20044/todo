package dev.rafaelbarragan.todo.domain.tarea.repository;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    @Query("""
    SELECT t FROM Tarea t 
    WHERE t.creador = :creador 
    AND t.fechaCreacion >= :inicioDelDia 
    AND t.fechaCreacion < :finDelDia
    """)
    Page<Tarea> buscarTodasHoy(@Param("creador") Usuario creador,
                               @Param("inicioDelDia") LocalDateTime inicioDelDia,
                               @Param("finDelDia") LocalDateTime finDelDia,
                               Pageable pageable);

}
