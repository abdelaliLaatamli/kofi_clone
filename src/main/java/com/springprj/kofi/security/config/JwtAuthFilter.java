package com.springprj.kofi.security.config;

import com.springprj.kofi.security.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

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

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;
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


        if( userEmail!= null && SecurityContextHolder.getContext().getAuthentication() == null ){
            UserDetails user = this.userDetailsService.loadUserByUsername(userEmail);//.loaduserByUsername(userEmail);
            if( jwtService.isTokenValid(jwt , user) ){
                UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(
                        user ,
                        null ,
                        user.getAuthorities());
                authtoken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authtoken);
            }
        }
        filterChain.doFilter(request , response);

    }
}
