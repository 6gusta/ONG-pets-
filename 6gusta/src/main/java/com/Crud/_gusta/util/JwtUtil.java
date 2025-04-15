package com.Crud._gusta.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;


@Component
public class JwtUtil {

    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000;
    private final Key key = SECRET_KEY;

    public String GerarToken(String nome, String role) {
        try {
            return Jwts.builder()
                    .setSubject(nome) // Define o nome do usuário no token
                    .claim("role", role)
                    .claim("nome", nome) // Adiciona a role do usuário como claim
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Expira em 24h
                    .signWith(key, SignatureAlgorithm.HS256) // Assina o token com chave secreta e HS256
                    .compact(); // Retorna o token como String
        } catch (Exception e) {
            e.printStackTrace(); // Log de erro em caso de falha na geração do token
            return null; // Retorna null em caso de falha
        }
    }

    public Claims extractClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key) // Define a chave para validar o token
                    .build()
                    .parseClaimsJws(token) // Analisa e valida o token assinado
                    .getBody(); // Retorna os dados contidos no token
        } catch (Exception e) {
            e.printStackTrace(); // Log de erro em caso de falha na análise do token
            return null; // Retorna null se não conseguir extrair as claims
        }
    }
}
