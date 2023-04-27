package com.monopolybankapp.config.security;

import io.jsonwebtoken.*;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JwtUtils {

    private static final Logger LOGGER = Logger.getLogger(JwtUtils.class.getName());

    private static final String SECRET_KEY = "mySecretKey"; // chave secreta usada para assinar o token
    private static final long EXPIRATION_TIME = 3600000; // tempo de expiração do token em milissegundos (1 hora)

    public String generateToken(String username) {
        // gera o token com o username e a chave secreta, definindo a data de expiração
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            LOGGER.log(Level.INFO,"token válido");
            return true;
        } catch (SignatureException e) {
            LOGGER.log(Level.INFO,"Assinatura do token inválida: " + e.getMessage());
        } catch (MalformedJwtException e) {
            LOGGER.log(Level.INFO,"Token inválido: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            LOGGER.log(Level.INFO,"Token expirado: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.log(Level.INFO,"Token não suportado: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.INFO,"String do token vazia ou nula: " + e.getMessage());
        }
        return false;
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


}
