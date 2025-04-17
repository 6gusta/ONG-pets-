package com.Crud._gusta.exceptionsGenerics;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("code", ex.getErrorCode());

        return ResponseEntity.badRequest().body(response);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "erro inesperado");
        response.put("detail", ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }


}
