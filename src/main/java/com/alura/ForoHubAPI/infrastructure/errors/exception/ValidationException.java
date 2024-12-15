package com.alura.ForoHubAPI.infrastructure.errors.exception;

public class ValidationException extends RuntimeException{

    public ValidationException(String mensaje){
        super(mensaje);
    }
}