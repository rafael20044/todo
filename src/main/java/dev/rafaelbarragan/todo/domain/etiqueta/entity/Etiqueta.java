package dev.rafaelbarragan.todo.domain.etiqueta.entity;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "etiquetas")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "etiquetas")
    private List<Tarea> tareas;
}
