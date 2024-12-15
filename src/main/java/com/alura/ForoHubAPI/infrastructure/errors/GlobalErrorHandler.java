package com.alura.ForoHubAPI.infrastructure.errors;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alura.ForoHubAPI.infrastructure.errors.exception.ValidationException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalErrorHandler {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> noFoundErrorHandler(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorValidationData>> noValidDataHandler(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors().stream().map(ErrorValidationData::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> validationErrorHandler(ValidationException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


    private record ErrorValidationData(String field, String error) {

        public ErrorValidationData(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
