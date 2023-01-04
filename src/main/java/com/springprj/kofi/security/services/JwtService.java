package com.springprj.kofi.security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "5A7134743677397A24432646294A404E635266556A586E327235753878214125";

    public  String  extractUsername(String token){
        return extractClaim(token , Claims::getSubject);
    }


    public String generateToken( UserDetails user ){
        return generateToken( new HashMap<>(), user);
    }
    public String generateToken(
            Map<String,Object> extraClaims ,
            UserDetails user
    ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject( user.getUsername() )
                .setIssuedAt( new Date( System.currentTimeMillis()))
                .setExpiration(new Date( System.currentTimeMillis() + ( 1000 * 60 * 24 ) ))
                .signWith( getSigningKey() , SignatureAlgorithm.HS256 )
                .compact();
    }
    public <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaimns(token);
        return  claimsResolver.apply(claims);
    }



    private Claims extractAllClaimns( String token ){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public boolean isTokenValid( String token , UserDetails user ){
        final String username = extractUsername(token);
        return username.equals( user.getUsername() ) && !isTokenExpired(token);
    }

    private boolean isTokenExpired( String token ){
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration( String token ){
        return extractClaim(token , Claims::getExpiration);
    }
    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
