package com.springprj.kofi.security.config;

import com.springprj.kofi.security.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.ManagedBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * JwtAuthFilter that class is the midleware that check the request have auth creadinials
 * OncePerRequestFilter this class make JwtAuthFilter as a midleware execute every request entre
 */
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt ;
        final String userEmail;

        if( authHeader==null || !authHeader.startsWith("Bearer ") ){
            filterChain.doFilter(request,response);
            return;
        }
        // get jwt from header
        jwt = authHeader.substring(7);

        // extract user Email
        userEmail = jwtService.extractUsername(jwt);



    }
}
