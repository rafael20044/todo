package dev.rafaelbarragan.todo.controller;

import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioCrear;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioRespuesta;
import dev.rafaelbarragan.todo.domain.usuario.dto.UsuarioVerificar;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import dev.rafaelbarragan.todo.domain.usuario.service.UsuarioService;
import dev.rafaelbarragan.todo.security.TokenDTO;
import dev.rafaelbarragan.todo.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UsuarioService service;
    private final TokenService tokenService;
    private final AuthenticationManager manager;

    @Autowired
    public LoginController(UsuarioService service, TokenService tokenService, AuthenticationManager manager ){
        this.service = service;
        this.tokenService = tokenService;
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity<UsuarioRespuesta> crear(@RequestBody @Valid UsuarioCrear crear,
                                                  UriComponentsBuilder builder){
        UsuarioRespuesta respuesta = service.crear(crear);
        URI uri = builder.path("/usuario/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @PostMapping("/iniciar")
    public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid UsuarioVerificar verificar){
        Authentication authToken = new UsernamePasswordAuthenticationToken(verificar.nombre(), verificar.clave());
        Authentication usuarioAutenticado = manager.authenticate(authToken);
        String JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(JWTtoken));
    }
}
