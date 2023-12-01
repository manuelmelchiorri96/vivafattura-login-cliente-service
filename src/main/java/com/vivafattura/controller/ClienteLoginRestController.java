package com.vivafattura.controller;

import com.vivafattura.dto.AuthenticationResponse;
import com.vivafattura.dto.ClienteDTO;
import com.vivafattura.service.UserDetailsServiceImpl;
import com.vivafattura.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/rest/api")
@RequiredArgsConstructor
public class ClienteLoginRestController {



    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody ClienteDTO clienteDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(clienteDTO.getUsername(), clienteDTO.getPassword()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(clienteDTO.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
    }


}
