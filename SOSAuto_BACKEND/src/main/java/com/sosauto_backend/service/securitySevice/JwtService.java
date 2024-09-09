package com.sosauto_backend.service.securitySevice;


import com.sosauto_backend.model.Entity.Personne;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    public void validateToken(String token){
        Jwts.parser().setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token);
    }

    public String extractnumTelephone(String token) {
        return extractClaim(token, Claims::getSubject);
    }


    public boolean isValid(String token, UserDetails user) {
        String username = extractnumTelephone(token);
        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    public String generateToken(Personne user) {
        String token = Jwts
                .builder()
                .subject(user.getNumTelephone())
                .claim("id",user.getPersonneid())
                .claim("role",user.getRole())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24*60*60*1000 ))
                .signWith(getSigninKey())
                .compact();

        return token;
    }

    private SecretKey getSigninKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}