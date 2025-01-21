package com.goktug.cargallerist.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "pyxeHmvIHdwtJDEAjFPRwp2d1xk7YSG5KHckqFy9h2g";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .signWith(getKeys(), SignatureAlgorithm.HS256)
                .compact();
    }

    public SecretKey getKeys() {
        byte[] bytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

    public <T> T exportToken(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = getClaims(token);
        return claimsTFunction.apply(claims);
    }

    public String getUsernameByToken(String token) {
        return exportToken(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token) {
        Date expireDate = exportToken(token, Claims::getExpiration);
        return new Date().before(expireDate);
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKeys())
                .build().parseClaimsJws(token).getBody();
    }
}

