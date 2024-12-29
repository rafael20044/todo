package dev.rafaelbarragan.todo.domain.tarea.entity;

import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;
import dev.rafaelbarragan.todo.domain.tarea.dto.TareaCrear;
import dev.rafaelbarragan.todo.domain.tarea.dto.TareaEditar;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "tareas")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario creador;

    private String titulo;

    private String descripcion;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaVencimiento;

    private boolean completada;

    @ManyToMany
    @JoinTable(
            name = "tarea_etiquetas",
            joinColumns = @JoinColumn(name = "tarea_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private List<Etiqueta> etiquetas;

    public Tarea(TareaCrear crear, Usuario usuario, List<Etiqueta> etiquetas) {
        this.creador = usuario;
        this.titulo = crear.titulo();
        this.descripcion = crear.descripcion();
        this.fechaCreacion = LocalDateTime.now();
        if (crear.dia_limite() != null) {
            this.fechaVencimiento = LocalDateTime.now().plusDays(crear.dia_limite());
        }
        this.completada = false;
        this.etiquetas = etiquetas;
    }

    public void editar(TareaEditar editar, List<Etiqueta> etiquetas){
        if(editar.titulo() != null){
            this.titulo = editar.titulo();
        }
        if(editar.descripcion() != null){
            this.descripcion = editar.descripcion();
        }
        if(editar.dia_vencimiento() != null){
            this.fechaVencimiento = LocalDateTime.now().plusDays(editar.dia_vencimiento());
        }
        this.etiquetas = etiquetas;
    }
}
