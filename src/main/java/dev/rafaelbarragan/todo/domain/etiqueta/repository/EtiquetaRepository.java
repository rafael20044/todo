package dev.rafaelbarragan.todo.domain.etiqueta.repository;

import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
