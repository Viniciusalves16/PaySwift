package com.api.PrePaymentAPI.security;

import com.api.PrePaymentAPI.entity.UserModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

//Classe que faz a criação do token
@Service
public class TokenService {
// This service generates and validates JWT tokens for user authentication in the application.

    @Value("${api.PrePaymentAPI.security.token.secret}")
    private String secret;

    public String generateToken(UserModel userModel) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("PaySwift_API")
                    .withSubject(userModel.getUsername())
                    .withExpiresAt(generateExpired())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating token ", e);
        }
    }

//Valida se o token recebido é valido
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("PaySwift_API")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    private Instant generateExpired() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
