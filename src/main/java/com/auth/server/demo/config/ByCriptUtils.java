package com.auth.server.demo.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ByCriptUtils {

    @Value("${jwt.secretKeyActual}")
    private String secret;

    public String generateToken(String passwordEncoder) {
        Date now = new Date();
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Jwts.builder()
                .setSubject(passwordEncoder)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 30 * 60 * 1000))
                .signWith(Keys.hmacShaKeyFor(keyBytes), SignatureAlgorithm.HS512)
                .compact();
    }
}