package dev.rafaelbarragan.todo.domain.usuario.entity;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioCrear;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Table(name = "usuarios")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String contrasena;

    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "creador")
    private List<Tarea> tareas;

    public Usuario(UsuarioCrear crear, String pass) {
        this.nombre = crear.nombre();
        this.correo = crear.correo();
        this.contrasena = pass;
        this.fechaCreacion = LocalDateTime.now();
        this.tareas = Collections.emptyList();
    }
}
