package dev.rafaelbarragan.todo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import dev.rafaelbarragan.todo.domain.usuario.entity.Usuario;
import dev.rafaelbarragan.todo.exception.TokenException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private final String keySecret = System.getenv("SECRET");

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(keySecret);
            return JWT.create()
                    .withIssuer("to-do")
                    .withSubject(usuario.getNombre())
                    .withExpiresAt(fechaVencimiento())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new TokenException(exception.getMessage());
        }
    }

    public String getSubject(String token){
        if (token == null) {
            throw new TokenException("Token nulo");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(keySecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("to-do")
                    // reusable verifier instance
                    .build();

            String subject = verifier.verify(token).getSubject();
            if (subject == null) {
                throw new TokenException("Token invalido");
            }
            return subject;
        } catch (JWTVerificationException exception){
            throw new TokenException(exception.getMessage());
        }
    }

    public Instant fechaVencimiento(){
        return LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
