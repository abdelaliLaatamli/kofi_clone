package com.springprj.kofi.auth;

import com.springprj.kofi.Repositories.UserRepository;
import com.springprj.kofi.models.Role;
import com.springprj.kofi.models.User;
import com.springprj.kofi.security.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private  final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {

        User UserR = userRepository.findByEmail(request.getEmail()).orElse(null);

        if(UserR != null) throw new RuntimeException("User already exist");

        User user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password( passwordEncoder.encode( request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token( jwtToken )
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception {

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getEmail() ,
                request.getPassword()
        );

        authenticationManager.authenticate( authentication );


        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new Exception("User not Found"));
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token( jwtToken )
                .build();
    }
}
