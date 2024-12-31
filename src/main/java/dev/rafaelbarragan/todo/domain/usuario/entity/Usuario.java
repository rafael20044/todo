package dev.rafaelbarragan.todo.domain.usuario.entity;

import dev.rafaelbarragan.todo.domain.tarea.entity.Tarea;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioCrear;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioEditar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Table(name = "usuarios")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String contrasena;

    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    private List<Tarea> tareas;

    public Usuario(UsuarioCrear crear, String pass) {
        this.nombre = crear.nombre();
        this.correo = crear.correo();
        this.contrasena = pass;
        this.fechaCreacion = LocalDateTime.now();
        this.tareas = Collections.emptyList();
    }

    public void agregarTarea(Tarea tarea){
        this.tareas.add(tarea);
    }

    public void editar(UsuarioEditar editar, String pass){
        if (editar.nombre() != null) {
            this.nombre = editar.nombre();
        }
        if (editar.correo() != null) {
            this.correo = editar.correo();
        }
        if (pass != null) {
            this.contrasena = pass;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.contrasena;
    }

    @Override
    public String getUsername() {
        return this.nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
