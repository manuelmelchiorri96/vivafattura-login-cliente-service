package com.vivafattura.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ClienteLoginRestControllerAdvice {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(BadCredentialsException ex, HttpServletResponse response) {

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Credenziali non valide");
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<?> handleDisabledException(DisabledException ex, HttpServletResponse response) {

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Account disabilitato");
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
    }

}
